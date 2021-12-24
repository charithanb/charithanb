package com.tourcoreservice.pojo.tourpackage;

public class TourPackagePartialPojo {

	private long id;

	private String name;

	private String duration;
	private int offer;
	private PlacePojo place;

	private ThemePojo theme;
	private PricePartialPojo price;

	private String pricecategory;
	private FacilityPojo facility;

	private String country;

	private long members;
	private String imgcdn;

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

	public PlacePojo getPlace() {
		return place;
	}

	public void setPlace(PlacePojo place) {
		this.place = place;
	}

	public ThemePojo getTheme() {
		return theme;
	}

	public void setTheme(ThemePojo theme) {
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

	
	public FacilityPojo getFacility() {
		return facility;
	}

	public void setFacility(FacilityPojo facility) {
		this.facility = facility;
	}

	public PricePartialPojo getPrice() {
		return price;
	}

	public void setPrice(PricePartialPojo price) {
		this.price = price;
	}

	public String getImgcdn() {
		return imgcdn;
	}

	public void setImgcdn(String imgcdn) {
		this.imgcdn = imgcdn;
	}

	public int getOffer() {
		return offer;
	}

	public void setOffer(int offer) {
		this.offer = offer;
	}
	
	
}
