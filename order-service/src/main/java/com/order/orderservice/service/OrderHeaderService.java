package com.order.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.orderservice.repository.OrderHeaderRepository;
import com.tourcoreservice.entity.OrderHeader;

@Service
public class OrderHeaderService {

	@Autowired
	private OrderHeaderRepository orderHeaderRepository;

	public OrderHeader create(OrderHeader orderHeader) {
		return orderHeaderRepository.save(orderHeader);
	}

	public List<OrderHeader> listAll() {
		return orderHeaderRepository.findAll();
	}

	public OrderHeader getOrderyId(Long id) {
		return orderHeaderRepository.findById(id).get();
	}

	public void deleteOrderHeader(long id) {
		orderHeaderRepository.deleteById(id);

	}

	public OrderHeader Update(OrderHeader orderHeader) {
		return orderHeaderRepository.save(orderHeader);
	}

}
