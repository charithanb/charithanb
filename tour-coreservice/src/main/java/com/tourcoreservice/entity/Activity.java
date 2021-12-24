package com.tourcoreservice.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	private String duration;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinTable(name = "activity_places")
	private Set<Place> places;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "theme_id")
	private Theme theme;

	private String pricecategory;

	private String country;

	private long members;

	private int offer;

	private String link;

	@Lob
	private String inclusion;

	@Lob
	private String exclusion;

	@Lob
	private String additionalinfo;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "facility_id")
	private Facility facility;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "price_id")
	private Price price;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinTable(name = "activities_assets")
	private Set<Asset> images;

	public Activity() {

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

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
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

	public Set<Place> getPlaces() {
		return places;
	}

	public void setPlaces(Set<Place> places) {
		this.places = places;
	}

	public Set<Asset> getImages() {
		return images;
	}

	public void setImages(Set<Asset> images) {
		this.images = images;
	}
	

}
