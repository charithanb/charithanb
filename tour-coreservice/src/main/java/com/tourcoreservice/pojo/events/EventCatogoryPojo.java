package com.tourcoreservice.pojo.events;

import java.util.Set;

import com.tourcoreservice.entity.events.EventPackages;

public class EventCatogoryPojo {
	
	private long id;
	
	private String category;
	
	private Set<EventPackages> eventPackage;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Set<EventPackages> getEventPackage() {
		return eventPackage;
	}

	public void setEventPackage(Set<EventPackages> eventPackage) {
		this.eventPackage = eventPackage;
	}
	
	

}
