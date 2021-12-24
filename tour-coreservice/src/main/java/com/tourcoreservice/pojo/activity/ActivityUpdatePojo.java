package com.tourcoreservice.pojo.activity;

import com.tourcoreservice.pojo.tourpackage.FacilityPojo;
import com.tourcoreservice.pojo.tourpackage.PlacePackagePojo;
import com.tourcoreservice.pojo.tourpackage.PricePojo;
import com.tourcoreservice.pojo.tourpackage.ThemePackagePojo;

public class ActivityUpdatePojo {

	private long id;

	private String name;

	private String duration;

	private PlacePackagePojo place;

	private ThemePackagePojo theme;

	private String pricecategory;

	private String country;

	private long members;

	private int offer;

	private String link;

	private String inclusion;

	private String exclusion;

	private String additionalinfo;

	private FacilityPojo facility;

	private PricePojo price;

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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public PlacePackagePojo getPlace() {
		return place;
	}

	public void setPlace(PlacePackagePojo place) {
		this.place = place;
	}

	public ThemePackagePojo getTheme() {
		return theme;
	}

	public void setTheme(ThemePackagePojo theme) {
		this.theme = theme;
	}

	public String getPricecategory() {
		return pricecategory;
	}

	public void setPricecategory(String pricecategory) {
		this.pricecategory = pricecategory;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getMembers() {
		return members;
	}

	public void setMembers(long members) {
		this.members = members;
	}

	public int getOffer() {
		return offer;
	}

	public void setOffer(int offer) {
		this.offer = offer;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getInclusion() {
		return inclusion;
	}

	public void setInclusion(String inclusion) {
		this.inclusion = inclusion;
	}

	public String getExclusion() {
		return exclusion;
	}

	public void setExclusion(String exclusion) {
		this.exclusion = exclusion;
	}

	public String getAdditionalinfo() {
		return additionalinfo;
	}

	public void setAdditionalinfo(String additionalinfo) {
		this.additionalinfo = additionalinfo;
	}

	public FacilityPojo getFacility() {
		return facility;
	}

	public void setFacility(FacilityPojo facility) {
		this.facility = facility;
	}

	public PricePojo getPrice() {
		return price;
	}

	public void setPrice(PricePojo price) {
		this.price = price;
	}

}
