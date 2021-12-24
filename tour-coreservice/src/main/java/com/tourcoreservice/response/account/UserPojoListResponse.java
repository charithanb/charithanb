package com.tourcoreservice.response.account;

import java.util.List;

import com.tourcoreservice.pojo.account.UserPojo;
import com.tourcoreservice.pojo.generic.AbstractPojoResponse;

public class UserPojoListResponse extends AbstractPojoResponse{
	List<UserPojo> userPojo;

	public List<UserPojo> getUserPojo() {
		return userPojo;
	}

	public void setUserPojo(List<UserPojo> userPojo) {
		this.userPojo = userPojo;
	}
	
	

}
