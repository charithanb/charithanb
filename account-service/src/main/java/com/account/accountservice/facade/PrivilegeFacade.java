package com.account.accountservice.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import com.account.accountservice.service.PrivilegeService;
import com.tourcoreservice.entity.Privilege;
import com.tourcoreservice.pojo.account.PrivilegePojo;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.response.account.PrivilegePojoListResponse;
import com.tourcoreservice.response.account.PrivilegePojoResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class PrivilegeFacade {

	@Autowired
	PrivilegeService privilegeService;

	@Value("${created.success}")
	private String createdSuccess;

	@Value("${updated.success}")
	private String updateSuccess;

	@Value("${deleted.success}")
	private String deleteSuccess;

	public PrivilegePojoResponse create(PrivilegePojo privilegePojo) {
		Privilege privilege = ObjectMapperUtils.map(privilegePojo, Privilege.class);
		privilege = privilegeService.create(privilege);
		privilegePojo = ObjectMapperUtils.map(privilege, PrivilegePojo.class);
		return createUpdateDeleteRespnse(createdSuccess, privilegePojo);
	}

	public PrivilegePojoListResponse getAll() {
		PrivilegePojoListResponse privilegePojoListResponse = new PrivilegePojoListResponse();
		List<Privilege> allPrivileges = privilegeService.getAll();
		List<PrivilegePojo> privilegePoj = ObjectMapperUtils.mapAll(allPrivileges, PrivilegePojo.class);
		privilegePojoListResponse.setPrivilegePojoList(privilegePoj);
		return privilegePojoListResponse;
	}

	private PrivilegePojoResponse createUpdateDeleteRespnse(String message, PrivilegePojo privilegePojo) {
		PrivilegePojoResponse response = new PrivilegePojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessaages = new ArrayList<ResponseMessagePojo>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessaages.add(responseMessagePojo);
		response.setPrivilegePojo(privilegePojo);
		response.setSuccessMessaages(successMessaages);
		return response;
	}

	public PrivilegePojoResponse update(PrivilegePojo privilegePojo) {
		Privilege privilege = privilegeService.findPrivilegeById(privilegePojo.getId());
		ObjectMapperUtils.map(privilegePojo, privilege);
		privilege = privilegeService.update(privilege);
		privilegePojo = ObjectMapperUtils.map(privilege, PrivilegePojo.class);
		return createUpdateDeleteRespnse(updateSuccess, privilegePojo);
	}

	public PrivilegePojoResponse delete(long id) {
		Privilege privilege = privilegeService.findPrivilegeById(id);
		privilegeService.delete(privilege);
		return createUpdateDeleteRespnse(deleteSuccess, null);
	}

	public PrivilegePojoResponse getPrivilegeById(long id) {
		Privilege privilege = privilegeService.findPrivilegeById(id);
		PrivilegePojo privilegePojo = ObjectMapperUtils.map(privilege, PrivilegePojo.class);
		return createUpdateDeleteRespnse("", privilegePojo);
	}

}
