package com.tourcoreservice.pojo.tourpackage;

import java.util.List;

public class TalukPojo {
	private long id;
	private String name;
	private DistrictPojo district;

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

	public DistrictPojo getDistrict() {
		return district;
	}

	public void setDistrict(DistrictPojo district) {
		this.district = district;
	}

}
