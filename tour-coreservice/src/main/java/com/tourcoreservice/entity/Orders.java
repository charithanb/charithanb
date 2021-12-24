package com.tourcoreservice.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	private String status;

	@CreatedBy
	private String createdBy;

	@CreatedDate
	private Date createdOn;
//
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
//	@JoinTable(name = "order_package")
//	private Set<CustomisePackage> packages;
//
//	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
//	@JoinTable(name = "order_user")
//	private User users;
//
//	
//	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.DETACH)
//	@JoinColumn(name="flightinfo_id")
//	private Set<CustomisePackageFlightinfo> flightInfo;
//	
//	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.DETACH)
//	@JoinColumn(name="hotelinfo_id")
//	private Set<CustomisePackageHotelInfo> hotel_info;
//	/*
//	 * @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
//	 * 
//	 * @JoinTable(name = "order_price") private List<Price> price;
//	 */
//
//	private String totalPrice;
//	
//	@Lob
//	private String inclusiontext;
//	@Lob
//	private String exlusionText;
//	@Lob
//	private String paymentPolicy;
//	@Lob
//	private String termsandconditions;
//	@Lob
//	private String aditionalinfo;

	/*
	 * public List<Price> getPrice() { return price; }
	 * 
	 * public void setPrice(List<Price> price) { this.price = price; }
	 */

	/*public String getTotalPrice() {
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

	

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public String getInclusiontext() {
		return inclusiontext;
	}

	public void setInclusiontext(String inclusiontext) {
		this.inclusiontext = inclusiontext;
	}

	public String getExlusionText() {
		return exlusionText;
	}

	public void setExlusionText(String exlusionText) {
		this.exlusionText = exlusionText;
	}

	public String getPaymentPolicy() {
		return paymentPolicy;
	}

	public void setPaymentPolicy(String paymentPolicy) {
		this.paymentPolicy = paymentPolicy;
	}

	public String getTermsandconditions() {
		return termsandconditions;
	}

	public void setTermsandconditions(String termsandconditions) {
		this.termsandconditions = termsandconditions;
	}

	public String getAditionalinfo() {
		return aditionalinfo;
	}

	public void setAditionalinfo(String aditionalinfo) {
		this.aditionalinfo = aditionalinfo;
	}

	public Set<CustomisePackageFlightinfo> getFlightInfo() {
		return flightInfo;
	}

	public void setFlightInfo(Set<CustomisePackageFlightinfo> flightInfo) {
		this.flightInfo = flightInfo;
	}

	public Set<CustomisePackageHotelInfo> getHotel_info() {
		return hotel_info;
	}

	public void setHotel_info(Set<CustomisePackageHotelInfo> hotel_info) {
		this.hotel_info = hotel_info;
	}*/
	

}
