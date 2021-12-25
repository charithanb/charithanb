package com.tourcoreservice.response.orders;

import java.util.List;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.ApproverPojo;

public class ApproverPojoListResponse extends AbstractPojoResponse{

	private List<ApproverPojo> approverPojo;

	public List<ApproverPojo> getApproverPojo() {
		return approverPojo;
	}

	public void setApproverPojo(List<ApproverPojo> approverPojo) {
		this.approverPojo = approverPojo;
	}
	
}
