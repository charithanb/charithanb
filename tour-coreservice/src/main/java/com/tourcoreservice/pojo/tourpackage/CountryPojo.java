package com.tourcoreservice.pojo.tourpackage;

public class CountryPojo {

	private long id;
	private String name;
	private RegionPojo region;

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

	public RegionPojo getRegion() {
		return region;
	}

	public void setRegion(RegionPojo region) {
		this.region = region;
	}

}
