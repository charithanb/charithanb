package com.tourcoreservice.entity.events;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class EventBanners {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Lob
	private byte[] image;
	private String gcsurl;
	private String heading;
	private String discription;
	private String date;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	
}
