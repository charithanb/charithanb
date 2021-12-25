package com.tourcoreservice.pojo.orders;

import java.util.Date;
import java.util.Set;

import com.tourcoreservice.entity.ApproverHirarchy;
import com.tourcoreservice.entity.CustomisePackage;

public class OrderHeaderPojo {

	private long id;

	private String craetedBy;

	private Date createdOn;

	private String updatedBy;

	private Date updatedOn;

	private long orderId;
	
	private String orderName;

	private long requesterId;

	private String status;
	
	private long creatorId;

	private CustomisePackage orderDetails;

	private Set<ApproverHirarchy> approverHirarchy;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCraetedBy() {
		return craetedBy;
	}

	public void setCraetedBy(String craetedBy) {
		this.craetedBy = craetedBy;
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

	public long getRequestedId() {
		return requesterId;
	}

	public void setRequestedId(long requestedId) {
		this.requesterId = requestedId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CustomisePackage getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(CustomisePackage orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Set<ApproverHirarchy> getApproverHirarchy() {
		return approverHirarchy;
	}

	public void setApproverHirarchy(Set<ApproverHirarchy> approverHirarchy) {
		this.approverHirarchy = approverHirarchy;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(long creatorId) {
		this.creatorId = creatorId;
	}

}
