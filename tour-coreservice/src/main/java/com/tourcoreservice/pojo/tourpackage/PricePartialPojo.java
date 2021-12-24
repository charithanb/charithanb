package com.tourcoreservice.pojo.tourpackage;

public class PricePartialPojo {
	
	private long id;
	private boolean isStandard;
	private boolean isDelux;
	private boolean isPremium;
	private long standardprice;
	private long deluxprice;
	private long premiumrprice;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isStandard() {
		return isStandard;
	}
	public void setStandard(boolean isStandard) {
		this.isStandard = isStandard;
	}
	public boolean isDelux() {
		return isDelux;
	}
	public void setDelux(boolean isDelux) {
		this.isDelux = isDelux;
	}
	public boolean isPremium() {
		return isPremium;
	}
	public void setPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}
	public long getStandardprice() {
		return standardprice;
	}
	public void setStandardprice(long standardprice) {
		this.standardprice = standardprice;
	}
	public long getDeluxprice() {
		return deluxprice;
	}
	public void setDeluxprice(long deluxprice) {
		this.deluxprice = deluxprice;
	}
	public long getPremiumrprice() {
		return premiumrprice;
	}
	public void setPremiumrprice(long premiumrprice) {
		this.premiumrprice = premiumrprice;
	}
	
	

}
