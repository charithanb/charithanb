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
public class BudgetPackageSuggest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinTable(name = "budgetpackageSuggest_place")
	private Place place;
	private long price;
	private int days;
	private String budget;
	private String type;
	private long maxprice;
	private String imgcdn;
	
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
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getMaxprice() {
		return maxprice;
	}
	public void setMaxprice(long maxprice) {
		this.maxprice = maxprice;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	public String getImgcdn() {
		return imgcdn;
	}
	public void setImgcdn(String imgcdn) {
		this.imgcdn = imgcdn;
	}
	

}
