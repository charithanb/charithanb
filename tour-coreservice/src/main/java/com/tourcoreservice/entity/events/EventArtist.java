package com.tourcoreservice.entity.events;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EventArtist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String socialmedia1;
	private String socialmedia2;
	private byte[] image;
	private String gcsurl;
	private String discription;
	
//	private Set<String> aadhar;

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

	public String getSocialmedia1() {
		return socialmedia1;
	}

	public void setSocialmedia1(String socialmedia1) {
		this.socialmedia1 = socialmedia1;
	}

	public String getSocialmedia2() {
		return socialmedia2;
	}

	public void setSocialmedia2(String socialmedia2) {
		this.socialmedia2 = socialmedia2;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getGcsurl() {
		return gcsurl;
	}

	public void setGcsurl(String gcsurl) {
		this.gcsurl = gcsurl;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	
}
