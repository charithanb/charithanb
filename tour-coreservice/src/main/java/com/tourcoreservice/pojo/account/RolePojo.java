package com.tourcoreservice.pojo.account;

import java.util.List;
import java.util.Set;

public class RolePojo {
	private long id;

	private String name;

	private String code;

	private List<PrivilegePojo> privileges;

	private RolePojo parentGroup;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<PrivilegePojo> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<PrivilegePojo> privileges) {
		this.privileges = privileges;
	}

	public RolePojo getParentGroup() {
		return parentGroup;
	}

	public void setParentGroup(RolePojo parentGroup) {
		this.parentGroup = parentGroup;
	}

}
