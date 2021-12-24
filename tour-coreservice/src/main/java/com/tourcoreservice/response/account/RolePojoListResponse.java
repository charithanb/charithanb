package com.tourcoreservice.response.account;

import java.util.List;

import com.tourcoreservice.pojo.account.RolePojo;
import com.tourcoreservice.pojo.generic.AbstractPojoResponse;

public class RolePojoListResponse extends AbstractPojoResponse {
	List<RolePojo> rolePojoList;

	public List<RolePojo> getRolePojoList() {
		return rolePojoList;
	}

	public void setRolePojoList(List<RolePojo> rolePojoList) {
		this.rolePojoList = rolePojoList;
	}

}
