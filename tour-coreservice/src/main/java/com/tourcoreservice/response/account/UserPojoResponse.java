package com.tourcoreservice.response.account;

import com.tourcoreservice.pojo.account.UserPojo;
import com.tourcoreservice.pojo.generic.AbstractPojoResponse;

public class UserPojoResponse extends AbstractPojoResponse{
	
	UserPojo userPojo;

	public UserPojo getUserPojo() {
		return userPojo;
	}

	public void setUserPojo(UserPojo userPojo) {
		this.userPojo = userPojo;
	}

	public void setAddressPojo(UserPojo userPojo2) {
		// TODO Auto-generated method stub
		
	}
	

}
