package com.tourcoreservice.pojo.events;

import java.util.Set;

import com.tourcoreservice.entity.Asset;

public class EventOrganiserPojo {
	
	private long id;
	private String name;
	private int eventNum;
	private int upcommingEvent;
	private int pastEvent;
	private String link;
	private int totalbookings;
	private int totalViews;
	private int totalEnq;
	private String socialMedia;
	private String about;
	private String phone;
	private String Email;
	private String companyName;
	private String city;
	private String zipcode;
	private String pan;
	private String address;
	private String state;
	private String gstn;
	private String bankName;
	private String account;
	private String branch;
	private String ifsc;
	private String benificiary;
	private Asset coverimage;
	private Set<Asset> panImage;
	
	
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
	public int getEventNum() {
		return eventNum;
	}
	public void setEventNum(int eventNum) {
		this.eventNum = eventNum;
	}
	public int getUpcommingEvent() {
		return upcommingEvent;
	}
	public void setUpcommingEvent(int upcommingEvent) {
		this.upcommingEvent = upcommingEvent;
	}
	public int getPastEvent() {
		return pastEvent;
	}
	public void setPastEvent(int pastEvent) {
		this.pastEvent = pastEvent;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getTotalbookings() {
		return totalbookings;
	}
	public void setTotalbookings(int totalbookings) {
		this.totalbookings = totalbookings;
	}
	public int getTotalViews() {
		return totalViews;
	}
	public void setTotalViews(int totalViews) {
		this.totalViews = totalViews;
	}
	public int getTotalEnq() {
		return totalEnq;
	}
	public void setTotalEnq(int totalEnq) {
		this.totalEnq = totalEnq;
	}
	public String getSocialMedia() {
		return socialMedia;
	}
	public void setSocialMedia(String socialMedia) {
		this.socialMedia = socialMedia;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getGstn() {
		return gstn;
	}
	public void setGstn(String gstn) {
		this.gstn = gstn;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public String getBenificiary() {
		return benificiary;
	}
	public void setBenificiary(String benificiary) {
		this.benificiary = benificiary;
	}
	public Asset getCoverimage() {
		return coverimage;
	}
	public void setCoverimage(Asset coverimage) {
		this.coverimage = coverimage;
	}
	public Set<Asset> getPanImage() {
		return panImage;
	}
	public void setPanImage(Set<Asset> panImage) {
		this.panImage = panImage;
	}
	
	

}
