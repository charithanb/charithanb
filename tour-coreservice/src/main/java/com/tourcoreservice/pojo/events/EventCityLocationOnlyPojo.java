package com.tourcoreservice.pojo.events;

import com.tourcoreservice.entity.events.EventCities;

public class EventCityLocationOnlyPojo {

	private long id;
	private String name;
	private EventCities cities;
	
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
	public EventCities getCities() {
		return cities;
	}
	public void setCities(EventCities cities) {
		this.cities = cities;
	}
	
}
