package com.tourcoreservice.response.orders;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.OrdersPojo;

public class OrderPojoResponse extends AbstractPojoResponse {
	public OrdersPojo ordersPojo;

	public OrdersPojo getOrdersPojo() {
		return ordersPojo;
	}

	public void setOrdersPojo(OrdersPojo ordersPojo) {
		this.ordersPojo = ordersPojo;
	}

}
