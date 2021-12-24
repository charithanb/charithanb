package com.tourcoreservice.entity.events;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class EventCatogory {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique=true)
	private String category;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
