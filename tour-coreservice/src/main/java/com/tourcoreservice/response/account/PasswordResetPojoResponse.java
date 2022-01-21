package com.tourcoreservice.response.account;

import com.tourcoreservice.pojo.account.PasswordResetPojo;
import com.tourcoreservice.pojo.generic.AbstractPojoResponse;

public class PasswordResetPojoResponse extends AbstractPojoResponse{

	
	private PasswordResetPojo passwordResetPojo;

	public PasswordResetPojo getPasswordResetPojo() {
		return passwordResetPojo;
	}

	public void setPasswordResetPojo(PasswordResetPojo passwordResetPojo) {
		this.passwordResetPojo = passwordResetPojo;
	}
	
}
