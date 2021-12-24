package com.tourcoreservice.entity.events;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MainEventDjs {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String discription;
	private String image;
	private String djid;
	
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
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDjid() {
		return djid;
	}
	public void setDjid(String djid) {
		this.djid = djid;
	}
	
	
}
