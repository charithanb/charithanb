package com.tourcoreservice.pojo.tourpackage;

import java.util.List;

public class DistrictPojo {
	private long id;
	private String name;
	private StatesPojo state;

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

	public StatesPojo getState() {
		return state;
	}

	public void setState(StatesPojo state) {
		this.state = state;
	}

}
