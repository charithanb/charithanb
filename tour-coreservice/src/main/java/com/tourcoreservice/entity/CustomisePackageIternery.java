package com.tourcoreservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class CustomisePackageIternery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	private String dayHeading;
	private Date date;
	private String dayPlace;
	@Lob
	private String headingDescription;
	@Lob
	private String description;
	@Lob
	private String note;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDayHeading() {
		return dayHeading;
	}
	public void setDayHeading(String dayHeading) {
		this.dayHeading = dayHeading;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDayPlace() {
		return dayPlace;
	}
	public void setDayPlace(String dayPlace) {
		this.dayPlace = dayPlace;
	}
	public String getHeadingDescription() {
		return headingDescription;
	}
	public void setHeadingDescription(String headingDescription) {
		this.headingDescription = headingDescription;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
	
}
