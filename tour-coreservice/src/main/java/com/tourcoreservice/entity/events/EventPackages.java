package com.tourcoreservice.entity.events;

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

import com.tourcoreservice.entity.Asset;
import com.tourcoreservice.entity.Theme;

@Entity
public class EventPackages {
  
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String heading;
	private String address;
	private String date;
	private String starts;
	private String ends;
	private String venue;
	private String note;
	@Lob
	private String maindiscription;
	@Lob
	private String additionalinfo;
	private boolean enable;
	private boolean publish;
	private String type;
	private double stagprice;
	private double ladiesprice;
	private double coupleprice;
	private String stagNote;
	private String ladiesNote;
	private String coupleNote;
	private int tickets;
	private String ticketName;
	private String price;
	private String discription;
	

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinTable(name = "eventpackages_places")
	private EventCities city;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinTable(name = "eventpackages_themes")
	private Theme theme;
	 
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinTable(name = "eventpackages_cover")
	private Asset coverimage;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinTable(name = "eventpackages_ticket")
	private Asset ticketimage;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinTable(name = "eventpackages_images")
	private Set<Asset> images;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinTable(name = "eventpackages_category")
	private Set<EventCatogory> categories;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStarts() {
		return starts;
	}

	public void setStarts(String starts) {
		this.starts = starts;
	}

	public String getEnds() {
		return ends;
	}

	public void setEnds(String ends) {
		this.ends = ends;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getMaindiscription() {
		return maindiscription;
	}

	public void setMaindiscription(String maindiscription) {
		this.maindiscription = maindiscription;
	}

	public String getAdditionalinfo() {
		return additionalinfo;
	}

	public void setAdditionalinfo(String additionalinfo) {
		this.additionalinfo = additionalinfo;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public boolean isPublish() {
		return publish;
	}

	public void setPublish(boolean publish) {
		this.publish = publish;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getStagprice() {
		return stagprice;
	}

	public void setStagprice(double stagprice) {
		this.stagprice = stagprice;
	}

	public double getLadiesprice() {
		return ladiesprice;
	}

	public void setLadiesprice(double ladiesprice) {
		this.ladiesprice = ladiesprice;
	}

	public double getCoupleprice() {
		return coupleprice;
	}

	public void setCoupleprice(double coupleprice) {
		this.coupleprice = coupleprice;
	}

	public String getStagNote() {
		return stagNote;
	}

	public void setStagNote(String stagNote) {
		this.stagNote = stagNote;
	}

	public String getLadiesNote() {
		return ladiesNote;
	}

	public void setLadiesNote(String ladiesNote) {
		this.ladiesNote = ladiesNote;
	}

	public String getCoupleNote() {
		return coupleNote;
	}

	public void setCoupleNote(String coupleNote) {
		this.coupleNote = coupleNote;
	}

	public int getTickets() {
		return tickets;
	}

	public void setTickets(int tickets) {
		this.tickets = tickets;
	}

	public String getTicketName() {
		return ticketName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public EventCities getCity() {
		return city;
	}

	public void setCity(EventCities city) {
		this.city = city;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public Asset getCoverimage() {
		return coverimage;
	}

	public void setCoverimage(Asset coverimage) {
		this.coverimage = coverimage;
	}

	public Asset getTicketimage() {
		return ticketimage;
	}

	public void setTicketimage(Asset ticketimage) {
		this.ticketimage = ticketimage;
	}

	public Set<Asset> getImages() {
		return images;
	}

	public void setImages(Set<Asset> images) {
		this.images = images;
	}

	public Set<EventCatogory> getCategories() {
		return categories;
	}

	public void setCategories(Set<EventCatogory> categories) {
		this.categories = categories;
	}
	
	
	
	
}
