package com.tourcoreservice.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

@Entity
public class InterNatPackageSuggest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinTable(name = "InterNatPackagesuggest_place")
	private Place place;
	private String startFrom;
	private long maxprice;
	private int days;
	private String imgcdn;
	
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
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
	public String getImgcdn() {
		return imgcdn;
	}
	public void setImgcdn(String imgcdn) {
		this.imgcdn = imgcdn;
	}
	
	
}
