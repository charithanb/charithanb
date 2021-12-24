package com.tourcoreservice.response.account;

import com.tourcoreservice.pojo.account.RolePojo;
import com.tourcoreservice.pojo.generic.AbstractPojoResponse;

public class RolePojoResponse extends AbstractPojoResponse {

	RolePojo rolePojo;

	public RolePojo getRolePojo() {
		return rolePojo;
	}

	public void setRolePojo(RolePojo rolePojo) {
		this.rolePojo = rolePojo;
	}

}
