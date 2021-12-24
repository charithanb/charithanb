package com.tourcoreservice.pojo.tourpackage;

public class BudgetPackageSuggestPojo {
	
	private long id;
	private String name;
	private PlacePojo place;
	private int days;
	private String budget;
	private String type;
	private long price;
	private long maxprice;
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
	public PlacePojo getPlace() {
		return place;
	}
	public void setPlace(PlacePojo place) {
		this.place = place;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public long getMaxprice() {
		return maxprice;
	}
	public void setMaxprice(long maxprice) {
		this.maxprice = maxprice;
	}
	public String getImgcdn() {
		return imgcdn;
	}
	public void setImgcdn(String imgcdn) {
		this.imgcdn = imgcdn;
	}
	
	
}
