package com.tourcoreservice.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class PackageSuggest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinTable(name = "packagesuggest_place")
	private Place place;
	private String startFrom;
	private long maxprice;
	@OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinTable(name = "packagesuggest_tourpackages")
	private Set<Tourpackage> tourpackages;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<Tourpackage> getTourpackages() {
		return tourpackages;
	}

	public void setTourpackages(Set<Tourpackage> tourpackages) {
		this.tourpackages = tourpackages;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public String getStartFrom() {
		return startFrom;
	}

	public void setStartFrom(String startFrom) {
		this.startFrom = startFrom;
	}

	public long getMaxprice() {
		return maxprice;
	}

	public void setMaxprice(long maxprice) {
		this.maxprice = maxprice;
	}

	
}
