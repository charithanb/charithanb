package com.tourcoreservice.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

@Entity
public class UserPasswordReset {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String oldPassword;

	private String newPassword;

	/*
	 * @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "user_password_reset") private User userId;
	 */
	
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
