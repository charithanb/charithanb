package com.tourcoreservice.response.account;

import com.tourcoreservice.pojo.account.PrivilegePojo;
import com.tourcoreservice.pojo.generic.AbstractPojoResponse;

public class PrivilegePojoResponse extends AbstractPojoResponse{
	PrivilegePojo privilegePojo;

	public PrivilegePojo getPrivilegePojo() {
		return privilegePojo;
	}

	public void setPrivilegePojo(PrivilegePojo privilegePojo) {
		this.privilegePojo = privilegePojo;
	}
	

}
