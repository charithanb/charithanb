package com.account.accountservice.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import com.account.accountservice.service.PrivilegeService;
import com.account.accountservice.service.RoleService;
import com.account.accountservice.service.UserService;
import com.tourcoreservice.entity.Privilege;
import com.tourcoreservice.entity.Role;
import com.tourcoreservice.entity.User;
import com.tourcoreservice.exception.account.ParentRolesCannotbeDeleted;
import com.tourcoreservice.pojo.account.RolePojo;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.response.account.RolePojoListResponse;
import com.tourcoreservice.response.account.RolePojoResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class RoleFacade {

	@Autowired
	RoleService roleService;

	@Autowired
	UserService userService;

	@Value("${created.success}")
	private String createdSuccess;

	@Value("${updated.success}")
	private String updateSuccess;

	@Value("${deleted.success}")
	private String deleteSuccess;

	@Value("${privilege.not.found}")
	private String privilegeNotFound;

	@Value("${role.customer}")
	private String roleCustomer;

	@Value("${role.employee}")
	private String roleEmployee;

	@Value("${parent.roles.cannot.deleted}")
	private String parentRolesCannotDeleted;

	@Autowired
	private PrivilegeService privilegeService;

	public RolePojoResponse create(RolePojo rolePojo) {
		Role role = ObjectMapperUtils.map(rolePojo, Role.class);
		String name = role.getName().toUpperCase();
		String code = role.getCode().toUpperCase();
		role.setName(name);
		role.setCode(code);
		role = roleService.create(role);
		rolePojo = ObjectMapperUtils.map(role, RolePojo.class);
		return createUpdateDeleteRespnse(createdSuccess, rolePojo);
	}

	public RolePojoListResponse getAllRoles() {
		RolePojoListResponse rolePojoListResponse = new RolePojoListResponse();
		List<Role> roles = roleService.findAllRoles();
		List<RolePojo> rolePojo = ObjectMapperUtils.mapAll(roles, RolePojo.class);
		rolePojoListResponse.setRolePojoList(rolePojo);
		return rolePojoListResponse;
	}

	public RolePojoResponse update(RolePojo rolePojo) {
		String name = rolePojo.getName().toUpperCase();
		String code = rolePojo.getCode().toUpperCase();
		rolePojo.setName(name);
		rolePojo.setCode(code);
		Role role = roleService.findRoleById(rolePojo.getId());
		deleteExistingPrivileges(role.getPrivileges(), role);
		ObjectMapperUtils.map(rolePojo, role);
		role = roleService.update(role);
		rolePojo = ObjectMapperUtils.map(role, RolePojo.class);
		return createUpdateDeleteRespnse(updateSuccess, rolePojo);
	}

	private void deleteExistingPrivileges(List<Privilege> privileges, Role role) {
		role.getPrivileges().removeAll(privileges);
		roleService.save(role);
	}

	private RolePojoResponse createUpdateDeleteRespnse(String message, RolePojo rolePojo) {
		RolePojoResponse response = new RolePojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessaages = new ArrayList<ResponseMessagePojo>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessaages.add(responseMessagePojo);
		response.setRolePojo(rolePojo);
		response.setSuccessMessaages(successMessaages);
		return response;
	}

	public RolePojoResponse delete(long id) {
		Role role = roleService.findRoleById(id);
		checkIfParentRole(role);
		for (User user : role.getUsers()) {
			userService.deleteUsersRoles(user);
		}
		if (!CollectionUtils.isEmpty(role.getPrivileges())) {
			role.getPrivileges().removeAll(role.getPrivileges());
			roleService.save(role);
		}
		roleService.delete(role);
		return createUpdateDeleteRespnse(deleteSuccess, null);
	}

	private void checkIfParentRole(Role role) {
		if (roleCustomer.equals(role.getName()) || roleEmployee.equals(role.getName())) {
			throw new ParentRolesCannotbeDeleted(parentRolesCannotDeleted);
		}

	}

	public RolePojoResponse addPrivilegeToRole(long roleId, long priviegeId) {
		Role role = roleService.findRoleById(roleId);
		List<Privilege> privilegeList = role.getPrivileges();
		Privilege privilege = privilegeService.findPrivilegeById(priviegeId);
		privilegeList.add(privilege);
		role.setPrivileges(privilegeList);
		role = roleService.update(role);
		RolePojo rolePojo = ObjectMapperUtils.map(role, RolePojo.class);
		return createUpdateDeleteRespnse(updateSuccess, rolePojo);
	}

	public RolePojoResponse deletePrivilegeForRole(long roleId, long priviegeId) {
		Role role = roleService.findRoleById(roleId);
		if (!CollectionUtils.isEmpty(role.getPrivileges())) {
			Privilege privilege = privilegeService.findPrivilegeById(priviegeId);
			role.getPrivileges().remove(privilege);
			role = roleService.update(role);
			return createUpdateDeleteRespnse(deleteSuccess, null);
		} else {
			return createUpdateDeleteRespnse(privilegeNotFound, null);
		}

	}

	public RolePojoResponse getRoleById(long roleId) {
		Role role = roleService.findRoleById(roleId);
		RolePojo rolePojo = ObjectMapperUtils.map(role, RolePojo.class);
		return createUpdateDeleteRespnse(null, rolePojo);
	}

	public RolePojoListResponse getParentRoles() {
		RolePojoListResponse rolePojoListResponse = new RolePojoListResponse();
		List<Role> roleEntityList = roleService.findParentRole();
		// add exception handler
		List<RolePojo> rolePojoList = ObjectMapperUtils.mapAll(roleEntityList, RolePojo.class);
		List<RolePojo> filterdRoles = new ArrayList<RolePojo>();
		rolePojoList.stream().forEach(role -> {
			if (role.getName().equals(roleEmployee) || role.getName().equals(roleCustomer)) {
				filterdRoles.add(role);
			}
		});
		rolePojoListResponse.setRolePojoList(filterdRoles);
		return rolePojoListResponse;
	}

	public RolePojoListResponse getEmployeeRoles() {
		RolePojoListResponse rolePojoListResponse = new RolePojoListResponse();
		List<Role> roleEntityList = roleService.findEmployeeRoles();
		List<RolePojo> rolePojoList = ObjectMapperUtils.mapAll(roleEntityList, RolePojo.class);
		List<RolePojo> filterdRolePojoList = new ArrayList<>();
		rolePojoList.stream().forEach(res -> {
			if (res.getName().equals(roleEmployee)) {
				filterdRolePojoList.add(res);
			}
		});
		rolePojoList.stream().forEach(result -> {
			if (!ObjectUtils.isEmpty(result.getParentGroup())) {
				if (result.getParentGroup().getName().equals(roleEmployee)) {
					filterdRolePojoList.add(result);
				}
			} // TODO Auto-generated method stub
		});
		rolePojoListResponse.setRolePojoList(filterdRolePojoList);

		return rolePojoListResponse;
	}

	public RolePojoListResponse customerRoles() {
		RolePojoListResponse rolePojoListResponse = new RolePojoListResponse();
		List<Role> roleEntityList = roleService.findCustomerRoles();
		List<RolePojo> rolePojoList = ObjectMapperUtils.mapAll(roleEntityList, RolePojo.class);
		List<RolePojo> filterdRolePojoList = new ArrayList<>();
		rolePojoList.stream().forEach(res -> {
			if (res.getName().equals(roleCustomer)) {
				filterdRolePojoList.add(res);
			}
		});
		rolePojoListResponse.setRolePojoList(filterdRolePojoList);

		return rolePojoListResponse;
	}

}
