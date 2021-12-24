package com.tourcoreservice.entity;

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
import javax.persistence.OneToOne;
import javax.persistence.Transient;
@Entity
public class Facility {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private boolean isflight;
	private boolean ismeal;
	private boolean iscab;
	private boolean ishotel;
	private boolean isactivity;
	private boolean issight;
	@Lob
	private  String smallDescripton;
	@Lob
	private String detailedDescription;
	@ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.DETACH)
	@JoinTable(name= "facilities_categories")
	private Set<Category> categories;
	
	@OneToOne(fetch=FetchType.LAZY,mappedBy="facility")
	@Transient
	private Activity activity;
	
	
	public boolean isIsflight() {
		
		return isflight;
	}
	public void setIsflight(boolean isflight) {
		this.isflight = isflight;
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
	public boolean isIshotel() {
		return ishotel;
	}
	public void setIshotel(boolean ishotel) {
		this.ishotel = ishotel;
	}
	
	
	public boolean isIssight() {
		return issight;
	}
	public void setIssight(boolean issight) {
		this.issight = issight;
	}
	public boolean isIsactivity() {
		return isactivity;
	}
	public void setIsactivity(boolean isactivity) {
		this.isactivity = isactivity;
	}
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	public String getSmallDescripton() {
		return smallDescripton;
	}
	public void setSmallDescripton(String smallDescripton) {
		this.smallDescripton = smallDescripton;
	}
	public String getDetailedDescription() {
		return detailedDescription;
	}
	public void setDetailedDescription(String detailedDescription) {
		this.detailedDescription = detailedDescription;
	}
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	} 
	
	
}
