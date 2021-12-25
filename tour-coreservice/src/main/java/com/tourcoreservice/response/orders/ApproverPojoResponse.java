package com.tourcoreservice.response.orders;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.ApproverPojo;

public class ApproverPojoResponse extends AbstractPojoResponse{

	private ApproverPojo approverPojo;

	public ApproverPojo getApproverPojo() {
		return approverPojo;
	}

	public void setApproverPojo(ApproverPojo approverPojo) {
		this.approverPojo = approverPojo;
	}
	
	
}
