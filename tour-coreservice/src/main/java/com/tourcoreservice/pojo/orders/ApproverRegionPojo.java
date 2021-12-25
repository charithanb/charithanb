package com.tourcoreservice.pojo.orders;

import java.util.Set;

import com.tourcoreservice.entity.Approver;

public class ApproverRegionPojo {

	private long id;

	private String regionName;

	private Set<Approver> approvers;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Set<Approver> getApprovers() {
		return approvers;
	}

	public void setApprovers(Set<Approver> approvers) {
		this.approvers = approvers;
	}

}
