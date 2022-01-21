package com.tourcoreservice.pojo.account;

import com.tourcoreservice.entity.User;

public class PasswordResetPojo {

	private long id;

	private String oldPassword;

	private String newPassword;

	//private User userId;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/*
	 * public User getUserId() { return userId; }
	 * 
	 * public void setUserId(User userId) { this.userId = userId; }
	 */
	
	}
