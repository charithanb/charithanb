package com.order.orderservice.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.order.orderservice.service.OrderService;
import com.tourcoreservice.entity.Orders;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.orders.OrdersPojo;
import com.tourcoreservice.response.orders.OrderPojoResponse;
import com.tourcoreservice.response.orders.OrdersPojoListResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class OrderFacade {

	@Autowired
	private OrderService orderService;

	public OrderPojoResponse create(OrdersPojo ordersPojo) {
		Orders orders = ObjectMapperUtils.map(ordersPojo, Orders.class);
		orders = orderService.create(orders);
		ordersPojo = ObjectMapperUtils.map(orders, OrdersPojo.class);
		return createDeleteUpdateResponse(ordersPojo, "Order created Successfully ");
	}

	private OrderPojoResponse createDeleteUpdateResponse(OrdersPojo ordersPojo, String message) {
		OrderPojoResponse orderPojoResponse = new OrderPojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessages = new ArrayList<>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessages.add(responseMessagePojo);
		orderPojoResponse.setOrdersPojo(ordersPojo);
		orderPojoResponse.setSuccessMessaages(successMessages);
		return orderPojoResponse;
	}

	public OrdersPojoListResponse listAll() {
		OrdersPojoListResponse ordersPojoListResponse = new OrdersPojoListResponse();
		List<Orders> orders = orderService.listAll();
		List<OrdersPojo> ordersPojo = ObjectMapperUtils.mapAll(orders, OrdersPojo.class);
		ordersPojoListResponse.setOrderPojo(ordersPojo);
		return ordersPojoListResponse;
	}

	public OrderPojoResponse delete(long id) {
		orderService.deleteOrder(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");

	}

	public OrderPojoResponse update(OrdersPojo ordersPojo) {
		Orders order = orderService.getOrderyId(ordersPojo.getId());
		ObjectMapperUtils.map(ordersPojo, order);
		order = orderService.Update(order);
		ordersPojo = ObjectMapperUtils.map(order, OrdersPojo.class);
		return createDeleteUpdateResponse(ordersPojo, "Updated successfully");
	}

	public OrderPojoResponse getOrderByid(Long id) {
		OrderPojoResponse orderPojoResponse = new OrderPojoResponse();
		Orders orders = orderService.getOrderyId(id);
		OrdersPojo ordersPojo = ObjectMapperUtils.map(orders, OrdersPojo.class);
		orderPojoResponse.setOrdersPojo(ordersPojo);
		return orderPojoResponse;
	}
}
