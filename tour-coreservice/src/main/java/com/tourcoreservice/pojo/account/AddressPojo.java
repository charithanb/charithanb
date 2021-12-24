package com.tourcoreservice.pojo.account;


public class AddressPojo {
	
	private long id;

	private String addresslineOne;
	private String addressLineTwo;
	private String areaCode;
	private String area;
	private String city;
	private String state;
	private String country;
	private String postalCode;
	private UserPojo user;
	
	

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddresslineOne() {
		return addresslineOne;
	}

	public void setAddresslineOne(String addresslineOne) {
		this.addresslineOne = addresslineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public UserPojo getUser() {
		return user;
	}

	public void setUser(UserPojo user) {
		this.user = user;
	}

	
}
