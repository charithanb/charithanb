package com.tourcoreservice.pojo.tourpackage;

public class TourPackageUpdatePojo {
	private long id;

	private String name;

	private String duration;

	private PlacePackagePojo place;

	private ThemePackagePojo theme;

	private String pricecategory;

	private String country;

	private long members;

	private int offer;
	
	private String daynight;

	private String imgcdn;
	private String link;

	private String lastdayDiscription;
	private String lastdayheading;

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
	
	

	public String getImgcdn() {
		return imgcdn;
	}

	public void setImgcdn(String imgcdn) {
		this.imgcdn = imgcdn;
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

	public String getDaynight() {
		return daynight;
	}

	public void setDaynight(String daynight) {
		this.daynight = daynight;
	}

	public String getLastdayDiscription() {
		return lastdayDiscription;
	}

	public void setLastdayDiscription(String lastdayDiscription) {
		this.lastdayDiscription = lastdayDiscription;
	}

	public String getLastdayheading() {
		return lastdayheading;
	}

	public void setLastdayheading(String lastdayheading) {
		this.lastdayheading = lastdayheading;
	}
	
	
	

}
