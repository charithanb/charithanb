package com.tourcoreservice.entity.events;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class EventCities {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique=true)
	private String city;
	private String country;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
