package com.tourcoreservice.pojo.account;

import java.util.List;
import java.util.Set;

public class EmployeePojo {
	private long employeeId;
	private String username;

	private String password;

	private long salary;

	private int age;

	private List<RolePojo> roles;
	private Set<AddressPojo> addresses;

	private long id;
	
	private String type;

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<RolePojo> getRoles() {
		return roles;
	}

	public void setRoles(List<RolePojo> roles) {
		this.roles = roles;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<AddressPojo> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<AddressPojo> addresses) {
		this.addresses = addresses;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
