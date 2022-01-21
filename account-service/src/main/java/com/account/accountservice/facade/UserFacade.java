package com.account.accountservice.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.account.accountservice.repository.LocalEmailServiceInterface;
import com.account.accountservice.service.UserService;
import com.tourcoreservice.entity.Address;
import com.tourcoreservice.entity.Role;
import com.tourcoreservice.entity.User;
import com.tourcoreservice.exception.tourpackage.DataAlreadyExistException;
import com.tourcoreservice.exception.tourpackage.DataDoesNotExistException;
import com.tourcoreservice.pojo.account.AddressPojo;
import com.tourcoreservice.pojo.account.UserPojo;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.response.account.UserPojoListResponse;
import com.tourcoreservice.response.account.UserPojoResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class UserFacade {

	@Autowired
	UserService userService;

	@Value("${customer.create.success}")
	private String customerCreatedSuccessfully;

	@Value("${customer.update.success}")
	private String updateSuccessfully;

	@Value("${customer.delete.success}")
	private String customerDeleteSuccessfully;

	@Autowired
	private LocalEmailServiceInterface localEmailServiceInterface;

	public UserPojoResponse create(UserPojo userPojo) {
		ifUserExist(userPojo.getId());
		User user = ObjectMapperUtils.map(userPojo, User.class);
		user = userService.create(user);
		try {
			localEmailServiceInterface.sendMailWithoutBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
		userPojo = ObjectMapperUtils.map(user, UserPojo.class);
		return createDeleteUpdateResponse(userPojo, customerCreatedSuccessfully);
	}

	private void ifUserExist(long id) {
		User user = userService.getById(id);
		if (!ObjectUtils.isEmpty(user)) {
			throw new DataAlreadyExistException("Data already exists");
		}

	}

	private UserPojoResponse createDeleteUpdateResponse(UserPojo userPojo, String message) {
		UserPojoResponse userPojoResponse = new UserPojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessages = new ArrayList<>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessages.add(responseMessagePojo);
		userPojoResponse.setUserPojo(userPojo);
		userPojoResponse.setSuccessMessaages(successMessages);
		return userPojoResponse;
	}

	public UserPojoListResponse listAll() {
		UserPojoListResponse userPojoListResponse = new UserPojoListResponse();
		List<User> user = userService.listAll();
		List<UserPojo> userPojo = ObjectMapperUtils.mapAll(user, UserPojo.class);
		userPojoListResponse.setUserPojo(userPojo);
		return userPojoListResponse;
	}

	public UserPojoResponse delete(long id) {
		ifUserDoesNotExist(id);
		userService.delete(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");
	}

	private void ifUserDoesNotExist(long id) {
		User user = userService.getById(id);
		if(ObjectUtils.isEmpty(user)) {
			throw new DataDoesNotExistException("Data doesn't exist");
		}
		
	}

	public UserPojoResponse update(UserPojo userPojo) {
		ifUserDoesNotExist(userPojo.getId());
		User user = userService.getById(userPojo.getId());
		deleteExisistingRole(user, user.getRoles());
		deleteExisistingAddress(user, user.getAddresses());
		ObjectMapperUtils.map(userPojo, user);
		user = userService.Update(user);
		userPojo = ObjectMapperUtils.map(user, UserPojo.class);
		return createDeleteUpdateResponse(userPojo, "Updated successfully");
	}

	private void deleteExisistingAddress(User user, Set<Address> addresses) {
		user.getAddresses().removeAll(addresses);
		userService.save(user);
	}

	private void deleteExisistingRole(User user, List<Role> roles) {
		user.getRoles().removeAll(roles);
		userService.save(user);
	}

	public UserPojoResponse getById(Long id) {
		ifUserDoesNotExist(id);
		User user = userService.getById(id);
		UserPojo userPojo = ObjectMapperUtils.map(user, UserPojo.class);
		return createDeleteUpdateResponse(userPojo, "");
	}

}
