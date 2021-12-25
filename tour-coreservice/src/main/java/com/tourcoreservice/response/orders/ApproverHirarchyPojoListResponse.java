package com.tourcoreservice.response.orders;

import java.util.List;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.ApproverHirarchyPojo;

public class ApproverHirarchyPojoListResponse extends AbstractPojoResponse  {

	private List<ApproverHirarchyPojo> approverHirarchyPojo;

	public List<ApproverHirarchyPojo> getApproverHirarchyPojo() {
		return approverHirarchyPojo;
	}

	public void setApproverHirarchyPojo(List<ApproverHirarchyPojo> approverHirarchyPojo) {
		this.approverHirarchyPojo = approverHirarchyPojo;
	}
	
}
