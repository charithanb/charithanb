package com.tourcoreservice.pojo.tourpackage;

import javax.persistence.Lob;

public class InclusionPojo {
	@Lob
	private String inclusion;
	@Lob 
	private String exclusion;
	@Lob
	private String  additionalinfo;
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
	
}
