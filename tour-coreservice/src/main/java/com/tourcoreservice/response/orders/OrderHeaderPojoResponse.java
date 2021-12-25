package com.tourcoreservice.response.orders;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.OrderHeaderPojo;

public class OrderHeaderPojoResponse extends AbstractPojoResponse {

	private OrderHeaderPojo OrderHeaderPojo;

	public OrderHeaderPojo getOrderHeaderPojo() {
		return OrderHeaderPojo;
	}

	public void setOrderHeaderPojo(OrderHeaderPojo orderHeaderPojo) {
		OrderHeaderPojo = orderHeaderPojo;
	}
	
}
