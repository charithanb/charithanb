package com.tourcoreservice.response.orders;

import java.util.List;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.ApproverRegionPojo;

public class ApproverRegionPojoListResponse extends AbstractPojoResponse {

	private List<ApproverRegionPojo> approversRegionPojo;

	public List<ApproverRegionPojo> getApproversRegionPojo() {
		return approversRegionPojo;
	}

	public void setApproversRegionPojo(List<ApproverRegionPojo> approversRegionPojo) {
		this.approversRegionPojo = approversRegionPojo;
	}
	
}
