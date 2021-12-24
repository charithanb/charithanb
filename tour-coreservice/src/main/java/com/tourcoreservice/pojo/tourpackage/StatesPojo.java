package com.tourcoreservice.pojo.tourpackage;

public class StatesPojo {

	private long id;
	private String name;
	private CountryPojo country;

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

	public CountryPojo getCountry() {
		return country;
	}

	public void setCountry(CountryPojo country) {
		this.country = country;
	}

}
