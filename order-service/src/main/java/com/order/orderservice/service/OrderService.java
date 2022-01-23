package com.order.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.orderservice.repository.OrderRepository;
import com.tourcoreservice.entity.Orders;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public Orders create(Orders orders) {
		return orderRepository.save(orders);
	}

	public List<Orders> listAll() {
		return orderRepository.findAll();
	}

	public void deleteOrder(long id) {
		orderRepository.deleteById(id);
		
	}

	public Orders getOrderyId(long id) {
		return orderRepository.findById(id);
	}

	public Orders Update(Orders orders) {
		return orderRepository.save(orders);
	}
}
