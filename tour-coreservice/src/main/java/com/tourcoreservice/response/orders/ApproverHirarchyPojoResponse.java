package com.tourcoreservice.response.orders;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.ApproverHirarchyPojo;

public class ApproverHirarchyPojoResponse extends AbstractPojoResponse  {

	private ApproverHirarchyPojo approverHirarchyPojo;

	public ApproverHirarchyPojo getApproverHirarchyPojo() {
		return approverHirarchyPojo;
	}

	public void setApproverHirarchyPojo(ApproverHirarchyPojo approverHirarchyPojo) {
		this.approverHirarchyPojo = approverHirarchyPojo;
	}
	
	
}
