package com.tourcoreservice.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class Iternery {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	 
//	@ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.DETACH)
//	@JoinTable(name= "iterneries_hotels")
//	private Set<Hotel> hotels;
	

	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.DETACH)
	@JoinTable(name="iterneries_package")
	private Tourpackage tourpackage;
	
//	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.DETACH)
//	@JoinTable(name="iterneries_assets")
//	private Set<Asset> images;
	
	public Iternery() {
		// TODO Auto-generated constructor stub
	}
	
	
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
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Tourpackage getTourpackage() {
		return tourpackage;
	}
	public void setTourpackage(Tourpackage tourpackage) {
		this.tourpackage = tourpackage;
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
//	public Set<Hotel> getHotels() {
//		return hotels;
//	}
//	public void setHotels(Set<Hotel> hotels) {
//		this.hotels = hotels;
//	}
//	public Set<Asset> getImages() {
//		return images;
//	}
//	public void setImages(Set<Asset> images) {
//		this.images = images;
//	}
//	
	
}
