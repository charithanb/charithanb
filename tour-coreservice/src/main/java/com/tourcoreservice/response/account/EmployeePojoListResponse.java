package com.tourcoreservice.response.account;

import java.util.List;

import com.tourcoreservice.pojo.account.EmployeePojo;
import com.tourcoreservice.pojo.generic.AbstractPojoResponse;

public class EmployeePojoListResponse extends AbstractPojoResponse {

	List<EmployeePojo> emploeePojo;

	public List<EmployeePojo> getEmploeePojo() {
		return emploeePojo;
	}

	public void setEmploeePojo(List<EmployeePojo> emploeePojo) {
		this.emploeePojo = emploeePojo;
	}

}
