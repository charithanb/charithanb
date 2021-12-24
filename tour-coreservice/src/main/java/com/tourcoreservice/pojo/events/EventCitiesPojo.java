package com.tourcoreservice.pojo.events;

import java.util.Set;

import com.tourcoreservice.entity.events.EventPackages;

public class EventCitiesPojo {
	private long id;
	
	private String city;
	private String country;
	private Set<EventPackages> eventPackage;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
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
	public Set<EventPackages> getEventPackage() {
		return eventPackage;
	}
	public void setEventPackage(Set<EventPackages> eventPackage) {
		this.eventPackage = eventPackage;
	}
	
}
