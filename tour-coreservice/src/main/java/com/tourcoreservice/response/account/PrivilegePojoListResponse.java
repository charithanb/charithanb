package com.tourcoreservice.response.account;

import java.util.List;

import com.tourcoreservice.pojo.account.PrivilegePojo;
import com.tourcoreservice.pojo.generic.AbstractPojoResponse;

public class PrivilegePojoListResponse extends AbstractPojoResponse {
	List<PrivilegePojo> privilegePojoList;

	public List<PrivilegePojo> getPrivilegePojoList() {
		return privilegePojoList;
	}

	public void setPrivilegePojoList(List<PrivilegePojo> privilegePojoList) {
		this.privilegePojoList = privilegePojoList;
	}

}
