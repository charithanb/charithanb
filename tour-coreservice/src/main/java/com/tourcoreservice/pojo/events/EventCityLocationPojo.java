package com.tourcoreservice.pojo.events;

import java.util.Set;

import com.tourcoreservice.entity.events.EventCities;
import com.tourcoreservice.entity.events.EventPackages;

public class EventCityLocationPojo {

	private long id;
	private String name;
	private EventCities cities;
	private Set<EventPackages> eventPackage;
	
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
	public Set<EventPackages> getEventPackage() {
		return eventPackage;
	}
	public void setEventPackage(Set<EventPackages> eventPackage) {
		this.eventPackage = eventPackage;
	}
	
	
}
