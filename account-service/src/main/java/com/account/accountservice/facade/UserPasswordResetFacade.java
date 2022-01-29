package com.account.accountservice.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.account.accountservice.service.UserPasswordResetService;
import com.tourcoreservice.entity.UserPasswordReset;
import com.tourcoreservice.pojo.account.PasswordResetPojo;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.response.account.PasswordResetPojoListResponse;
import com.tourcoreservice.response.account.PasswordResetPojoResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class UserPasswordResetFacade {

	@Autowired
	UserPasswordResetService userPasswordResetService;

	public PasswordResetPojoResponse createPasswordReset(PasswordResetPojo passwordResetPojo) {
		UserPasswordReset userPasswordReset = ObjectMapperUtils.map(passwordResetPojo, UserPasswordReset.class);
		userPasswordReset = userPasswordResetService.create(userPasswordReset);
		passwordResetPojo = ObjectMapperUtils.map(userPasswordReset, PasswordResetPojo.class);
		return createDeleteUpdatePasswordResponse(passwordResetPojo, "Password created Successfully ");
	}

	public PasswordResetPojoResponse passwordReset(PasswordResetPojo passwordResetPojo) {
		UserPasswordReset passwordReset = ObjectMapperUtils.map(passwordResetPojo, UserPasswordReset.class);
		UserPasswordReset passReset = userPasswordResetService.updatePasswardById(passwordReset);
		PasswordResetPojo passResetPojo = ObjectMapperUtils.map(passReset, PasswordResetPojo.class);
		return createDeleteUpdatePasswordResponse(passResetPojo, "Updated successfully");

	}

	private PasswordResetPojoResponse createDeleteUpdatePasswordResponse(PasswordResetPojo passResetPojo,
			String message) {
		PasswordResetPojoResponse passwordResetPojoResponse = new PasswordResetPojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessages = new ArrayList<>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessages.add(responseMessagePojo);
		passwordResetPojoResponse.setPasswordResetPojo(passResetPojo);
		passwordResetPojoResponse.setSuccessMessaages(successMessages);
		return passwordResetPojoResponse;
	}

	public PasswordResetPojoListResponse listAll() {
		PasswordResetPojoListResponse passwordResetPojoListResponse = new PasswordResetPojoListResponse();
		List<UserPasswordReset> userPasswordReset = userPasswordResetService.findAll();
		List<PasswordResetPojo> passwordResetPojo = ObjectMapperUtils.mapAll(userPasswordReset,
				PasswordResetPojo.class);
		passwordResetPojoListResponse.setPasswordResetPojo(passwordResetPojo);
		return passwordResetPojoListResponse;
	}

	public PasswordResetPojoResponse getPasswordResetByid(Long id) {
		PasswordResetPojoResponse passwordResetPojoResponse = new PasswordResetPojoResponse();
		UserPasswordReset userPasswordReset = userPasswordResetService.findPasswordById(id);
		PasswordResetPojo PasswordResetPojo = ObjectMapperUtils.map(userPasswordReset, PasswordResetPojo.class);
		passwordResetPojoResponse.setPasswordResetPojo(PasswordResetPojo);
		return passwordResetPojoResponse;
	}

	public PasswordResetPojoResponse delete(long id) {
		userPasswordResetService.deletePasswordById(id);
		return createDeleteUpdatePasswordResponse(null, "Password deleted successfully");

	}

}
