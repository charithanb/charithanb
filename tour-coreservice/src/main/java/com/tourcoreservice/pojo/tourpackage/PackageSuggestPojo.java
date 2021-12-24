package com.tourcoreservice.pojo.tourpackage;

import java.util.Set;

public class PackageSuggestPojo{
	private long id;
	private String name;
	private PlacePojo place;
	private String startFrom;
	private Set<TourpackagePojo> tourpackages;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id; 
	}
	
	public Set<TourpackagePojo> getTourpackages() {
		return tourpackages;
	}
	public void setTourpackages(Set<TourpackagePojo> tourpackages) {
		this.tourpackages = tourpackages;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PlacePojo getPlace() {
		return place;
	}
	public void setPlace(PlacePojo place) {
		this.place = place;
	}
	public String getStartFrom() {
		return startFrom;
	}
	public void setStartFrom(String startFrom) {
		this.startFrom = startFrom;
	}
	
}
