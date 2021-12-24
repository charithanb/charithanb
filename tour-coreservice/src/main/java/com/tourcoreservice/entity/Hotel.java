package com.tourcoreservice.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Hotel {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private int star;
	private String address;
	private String location;
	private long phonenumber;
	@ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.DETACH)
	@JoinTable(name= "hotels_categories")
	private Set<Category> categories;
	private String Email;
	private String details;
	private String detailedDescription;
	@ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.DETACH)
	@JoinTable(name= "hotels_assets")
	private  Set<Asset> images;
	
	
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
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getAddredss() {
		return address;
	}
	public void setAddredss(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getDetailedDescription() {
		return detailedDescription;
	}
	public void setDetailedDescription(String detailedDescription) {
		this.detailedDescription = detailedDescription;
	}
	public Set<Asset> getImages() {
		return images;
	}
	public void setImages(Set<Asset> images) {
		this.images = images;
	}
	
}
