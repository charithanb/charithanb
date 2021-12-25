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

import com.order.orderservice.facade.OrderHeaderFacade;
import com.tourcoreservice.pojo.orders.OrderHeaderPojo;
import com.tourcoreservice.response.orders.OrderHeaderPojoListResponse;
import com.tourcoreservice.response.orders.OrderHeaderPojoResponse;

@RestController
@RequestMapping("/order-header")
public class OrderHeaderController {

	@Autowired
	private OrderHeaderFacade orderHeaderFacade;

	@PostMapping
	public OrderHeaderPojoResponse createOrderHeader(@RequestBody OrderHeaderPojo orderHeaderPojo) {
		return orderHeaderFacade.create(orderHeaderPojo);

	}

	@GetMapping
	public OrderHeaderPojoListResponse getAllOrderHeaders() {
		return orderHeaderFacade.listAll();
	}

	@GetMapping("/{id}")
	public OrderHeaderPojoResponse getOrderHeaderById(@PathVariable Long id) {
		return orderHeaderFacade.getOrderHeaderByid(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		orderHeaderFacade.delete(id);
	}

	@PutMapping
	public OrderHeaderPojoResponse updateOrderHeaderById(@RequestBody OrderHeaderPojo orderHeaderPojo) {
		return orderHeaderFacade.update(orderHeaderPojo);
	}
}
