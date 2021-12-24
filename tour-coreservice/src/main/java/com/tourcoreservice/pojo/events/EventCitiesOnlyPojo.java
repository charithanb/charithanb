package com.tourcoreservice.pojo.events;

public class EventCitiesOnlyPojo {
	private long id;
	private String city;
	private String country;
	public String getCity() {
		return city;
	}
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}
