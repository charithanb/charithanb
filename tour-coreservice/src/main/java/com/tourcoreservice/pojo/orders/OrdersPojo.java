package com.tourcoreservice.pojo.orders;

import java.sql.Date;
import java.util.Set;

import com.tourcoreservice.pojo.account.UserPojo;
import com.tourcoreservice.pojo.tourpackage.TourpackagePojo;

public class OrdersPojo {
	private long id;

	private String name;

	private String status;

	private String createdBy;

	private Date createdOn;

	private Set<TourpackagePojo> tourpackage;

	private UserPojo users;

	// private List<PricePojo> price;

	private String totalPrice;

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Set<TourpackagePojo> getTourpackage() {
		return tourpackage;
	}

	public void setTourpackage(Set<TourpackagePojo> tourpackage) {
		this.tourpackage = tourpackage;
	}

	public UserPojo getUsers() {
		return users;
	}

	public void setUsers(UserPojo users) {
		this.users = users;
	}

	/*
	 * public List<PricePojo> getPrice() { return price; }
	 * 
	 * public void setPrice(List<PricePojo> price) { this.price = price; }
	 */

}
