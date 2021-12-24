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
public class EventThemes {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique=true)
	private String theme;
	private String image;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<EventPackages> eventPackage;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Set<EventPackages> getEventPackage() {
		return eventPackage;
	}
	public void setEventPackage(Set<EventPackages> eventPackage) {
		this.eventPackage = eventPackage;
	}
	
	
	
}
