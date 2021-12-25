package com.tourcoreservice.pojo.orders;

import java.util.Set;

import com.tourcoreservice.entity.User;

public class ApproverPojo {

	private long id;

	private String firstName;

	private String lastName;

	private User employee;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public User getEmployee() {
		return employee;
	}

	public void setEmployee(User employee) {
		this.employee = employee;
	}



}
