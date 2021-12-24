package com.tourcoreservice.pojo.events;

public class MainEventPubsPojo {
	private long id;
	private String name;
	private String discription;
	private String place;
	private String map;
	private String image;
	private boolean isfood;
	private boolean isdrink;
	private boolean isparking;
	private boolean ismusic;
	private boolean isgarden;
	private String pubId;
	
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
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getMap() {
		return map;
	}
	public void setMap(String map) {
		this.map = map;
	}
	public boolean isIsfood() {
		return isfood;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setIsfood(boolean isfood) {
		this.isfood = isfood;
	}
	public boolean isIsdrink() {
		return isdrink;
	}
	public void setIsdrink(boolean isdrink) {
		this.isdrink = isdrink;
	}
	public boolean isIsparking() {
		return isparking;
	}
	public void setIsparking(boolean isparking) {
		this.isparking = isparking;
	}
	public boolean isIsmusic() {
		return ismusic;
	}
	public void setIsmusic(boolean ismusic) {
		this.ismusic = ismusic;
	}
	public boolean isIsgarden() {
		return isgarden;
	}
	public void setIsgarden(boolean isgarden) {
		this.isgarden = isgarden;
	}
	public String getPubId() {
		return pubId;
	}
	public void setPubId(String pubId) {
		this.pubId = pubId;
	}
	
}
