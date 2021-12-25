package com.tourcoreservice.pojo.orders;

import java.util.Date;
import java.util.Set;

import com.tourcoreservice.entity.Approver;

public class ApproverHirarchyPojo {

	private long id;

	private String createdBy;

	private Date createdOn;

	private String updatedBy;

	private Date updatedOn;

	private long orderId;

	private long creatorId;

	private Set<Approver> approver;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(long creatorId) {
		this.creatorId = creatorId;
	}

	public Set<Approver> getApprover() {
		return approver;
	}

	public void setApprover(Set<Approver> approver) {
		this.approver = approver;
	}

}
