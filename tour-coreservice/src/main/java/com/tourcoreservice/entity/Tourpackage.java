package com.tourcoreservice.entity;

import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Tourpackage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String daynight;
	private String duration;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinTable(name = "tourpackages_places")
	private Place place;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinTable(name = "tourpackages_themes")
	private Theme theme;
	
	private String country;
	
	private long members;
	
	private int offer;
	
	private String link;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinTable(name = "tourpackages_assets")
	private Set<Asset> images;
	
	private String imgcdn;
	
	@Lob
	private String inclusion;
	
	@Lob
	private String exclusion;
	
	@Lob
	private String additionalinfo;
	
	@Lob
	private String lastdayDiscription;
	private String lastdayheading;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "tourpackages_facilities")
	private Facility facility;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "tourpackages_prices")
	private Price price;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Iternery> iterneries;
	
	public Set<Asset> getImages() {
		return images;
	}

	public void setImages(Set<Asset> images) {
		this.images = images;
	}

	public Tourpackage() {

	}

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

	public int getOffer() {
		return offer;
	}

	public void setOffer(int offer) {
		this.offer = offer;
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

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
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

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public List<Iternery> getIterneries() {
		return iterneries;
	}

	public void setIterneries(List<Iternery> iterneries) {
		this.iterneries = iterneries;
	}

	public String getImgcdn() {
		return imgcdn;
	}

	public void setImgcdn(String imgcdn) {
		this.imgcdn = imgcdn;
	}

	public String getDaynight() {
		return daynight;
	}

	public void setDaynight(String daynight) {
		this.daynight = daynight;
	}

	

	
	
	

}
