package com.tourcoreservice.response.account;

import java.util.List;

import com.tourcoreservice.pojo.account.PasswordResetPojo;
import com.tourcoreservice.pojo.generic.AbstractPojoResponse;

public class PasswordResetPojoListResponse extends AbstractPojoResponse{

	private List<PasswordResetPojo> passwordResetPojo;

	public List<PasswordResetPojo> getPasswordResetPojo() {
		return passwordResetPojo;
	}

	public void setPasswordResetPojo(List<PasswordResetPojo> passwordResetPojo) {
		this.passwordResetPojo = passwordResetPojo;
	}
	
}
