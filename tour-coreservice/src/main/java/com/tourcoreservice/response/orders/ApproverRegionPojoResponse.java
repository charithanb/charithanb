package com.tourcoreservice.response.orders;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.ApproverRegionPojo;

public class ApproverRegionPojoResponse extends AbstractPojoResponse {

	private ApproverRegionPojo approversRegionPojo;

	public ApproverRegionPojo getApproversRegionPojo() {
		return approversRegionPojo;
	}

	public void setApproversRegionPojo(ApproverRegionPojo approversRegionPojo) {
		this.approversRegionPojo = approversRegionPojo;
	}
	
}
