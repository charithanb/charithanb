package com.tourcoreservice.pojo.orders;

import java.util.Date;

public class CustomisePackageIteneryPojo {

	private long id;

	private String dayHeading;

	private Date date;

	private String dayPlace;

	private String headingDescription;

	private String description;

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
