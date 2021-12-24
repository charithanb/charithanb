package com.tourcoreservice.entity.events;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class EventCityLocation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true)
	private String name;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinTable(name = "event_citiesJoin")
	private EventCities city;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

	
	public EventCities getCity() {
		return city;
	}

	public void setCity(EventCities city) {
		this.city = city;
	}

	public Set<EventPackages> getEventPackage() {
		return eventPackage;
	}

	public void setEventPackage(Set<EventPackages> eventPackage) {
		this.eventPackage = eventPackage;
	}
	
	

}
