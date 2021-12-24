package com.order.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.orderservice.facade.OrderFacade;
import com.tourcoreservice.pojo.orders.OrdersPojo;
import com.tourcoreservice.response.orders.OrderPojoResponse;
import com.tourcoreservice.response.orders.OrdersPojoListResponse;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderFacade orderFacade;

	@PostMapping
	public OrderPojoResponse createOrder(@RequestBody OrdersPojo ordersPojo) {
		return orderFacade.create(ordersPojo);

	}

	@GetMapping
	public OrdersPojoListResponse getAllOrders() {
		return orderFacade.listAll();
	}

	@GetMapping("/{id}")
	public OrderPojoResponse getOrderById(@PathVariable Long id) {
		return orderFacade.getOrderByid(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		orderFacade.delete(id);
	}

	@PutMapping
	public OrderPojoResponse updateOrderById(@RequestBody OrdersPojo ordersPojo) {
		return orderFacade.update(ordersPojo);
	}

}
