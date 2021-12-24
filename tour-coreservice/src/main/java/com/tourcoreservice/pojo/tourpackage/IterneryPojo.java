package com.tourcoreservice.pojo.tourpackage;

public class IterneryPojo {

	private long id;
	private long day;
	private String place;
	private String address;
	private String dayheading;
	private String  daydescription;
	private boolean ishotel;
	private boolean ismeal;
	private boolean iscab;
	private boolean isactivity;
	private boolean issight;
	private boolean isflight;
	private String imgcdn1;
	private String imgcdn2;
	private String imgcdn3;
	private String hotelname;
	private String hotelLocation;
	private String hotRating;
	private String hotAddress;
	private String hotelroom;
	
//	private Set<AssetPojo> images;
	private TourpackagePojo tourpackage;
	
	
	public String getImgcdn1() {
		return imgcdn1;
	}

	public void setImgcdn1(String imgcdn1) {
		this.imgcdn1 = imgcdn1;
	}

	public String getImgcdn2() {
		return imgcdn2;
	}

	public void setImgcdn2(String imgcdn2) {
		this.imgcdn2 = imgcdn2;
	}

	public String getImgcdn3() {
		return imgcdn3;
	}

	public void setImgcdn3(String imgcdn3) {
		this.imgcdn3 = imgcdn3;
	}


	public String getHotelname() {
		return hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}

	public String getHotelLocation() {
		return hotelLocation;
	}

	public void setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
	}

	public String getHotRating() {
		return hotRating;
	}

	public void setHotRating(String hotRating) {
		this.hotRating = hotRating;
	}

	public String getHotAddress() {
		return hotAddress;
	}

	public void setHotAddress(String hotAddress) {
		this.hotAddress = hotAddress;
	}

	public String getHotelroom() {
		return hotelroom;
	}

	public void setHotelroom(String hotelroom) {
		this.hotelroom = hotelroom;
	}


	public boolean isIsactivity() {
		return isactivity;
	}

	public void setIsactivity(boolean isactivity) {
		this.isactivity = isactivity;
	}

	public boolean isIssight() {
		return issight;
	}

	public void setIssight(boolean issight) {
		this.issight = issight;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getDay() {
		return day;
	}

	public void setDay(long day) {
		this.day = day;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDayheading() {
		return dayheading;
	}

	public void setDayheading(String dayheading) {
		this.dayheading = dayheading;
	}

	public String getDaydescription() {
		return daydescription;
	}

	public void setDaydescription(String daydescription) {
		this.daydescription = daydescription;
	}

	public boolean isIshotel() {
		return ishotel;
	}

	public void setIshotel(boolean ishotel) {
		this.ishotel = ishotel;
	}

	public boolean isIsmeal() {
		return ismeal;
	}

	public void setIsmeal(boolean ismeal) {
		this.ismeal = ismeal;
	}

	public boolean isIscab() {
		return iscab;
	}

	public void setIscab(boolean iscab) {
		this.iscab = iscab;
	}

	public boolean isIsflight() {
		return isflight;
	}

	public void setIsflight(boolean isflight) {
		this.isflight = isflight;
	}

//	public Set<HotelPojo> getHotels() {
//		return hotels;
//	}
//
//	public void setHotels(Set<HotelPojo> hotels) {
//		this.hotels = hotels;
//	}

	public TourpackagePojo getTourpackage() {
		return tourpackage;
	}

	public void setTourpackage(TourpackagePojo tourpackage) {
		this.tourpackage = tourpackage;
	}

//	public Set<AssetPojo> getImages() {
//		return images;
//	}
//
//	public void setImages(Set<AssetPojo> images) {
//		this.images = images;
//	}

}
