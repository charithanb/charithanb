package com.tourcoreservice.response.orders;

import java.util.List;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.OrdersPojo;

public class OrdersPojoListResponse extends AbstractPojoResponse {

	private List<OrdersPojo> orderPojo;

	public List<OrdersPojo> getOrderPojo() {
		return orderPojo;
	}

	public void setOrderPojo(List<OrdersPojo> orderPojo) {
		this.orderPojo = orderPojo;
	}
}
