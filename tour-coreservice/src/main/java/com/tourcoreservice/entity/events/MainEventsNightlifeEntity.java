package com.tourcoreservice.entity.events;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MainEventsNightlifeEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	private String image;
	private String date;
	private String discription;
	private String offer;
	private String category;
	private String nightLifeId;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getOffer() {
		return offer;
	}
	public void setOffer(String offer) {
		this.offer = offer;
	}
	public String getNightLifeId() {
		return nightLifeId;
	}
	public void setNightLifeId(String nightLifeId) {
		this.nightLifeId = nightLifeId;
	}
	

}
