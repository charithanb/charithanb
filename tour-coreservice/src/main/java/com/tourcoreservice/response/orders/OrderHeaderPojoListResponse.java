package com.tourcoreservice.response.orders;

import java.util.List;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.OrderHeaderPojo;

public class OrderHeaderPojoListResponse extends AbstractPojoResponse{

	private List<OrderHeaderPojo> OrderHeaderPojo;

	public List<OrderHeaderPojo> getOrderHeaderPojo() {
		return OrderHeaderPojo;
	}

	public void setOrderHeaderPojo(List<OrderHeaderPojo> orderHeaderPojo) {
		OrderHeaderPojo = orderHeaderPojo;
	}


	
}
