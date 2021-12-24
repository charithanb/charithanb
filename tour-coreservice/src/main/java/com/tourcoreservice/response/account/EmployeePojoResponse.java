package com.tourcoreservice.response.account;

import com.tourcoreservice.pojo.account.EmployeePojo;
import com.tourcoreservice.pojo.generic.AbstractPojoResponse;

public class EmployeePojoResponse extends AbstractPojoResponse {
	EmployeePojo employeePojo;

	public EmployeePojo getEmployeePojo() {
		return employeePojo;
	}

	public void setEmployeePojo(EmployeePojo employeePojo) {
		this.employeePojo = employeePojo;
	}

}
