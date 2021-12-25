package com.order.orderservice.facade;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.order.orderservice.service.ApproverHirarchyService;
import com.order.orderservice.service.OrderHeaderService;
import com.tourcoreservice.entity.ApproverHirarchy;
import com.tourcoreservice.entity.OrderHeader;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.orders.OrderHeaderPojo;
import com.tourcoreservice.response.orders.OrderHeaderPojoListResponse;
import com.tourcoreservice.response.orders.OrderHeaderPojoResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class OrderHeaderFacade {

	@Autowired
	private OrderHeaderService orderHeaderService;

	@Autowired
	private ApproverHirarchyService approverHirarchyService;
	
	public OrderHeaderPojoResponse create(OrderHeaderPojo orderHeaderPojo) {
		OrderHeader orderHeader = ObjectMapperUtils.map(orderHeaderPojo, OrderHeader.class);
		orderHeader = orderHeaderService.create(orderHeader);
		orderHeaderPojo = ObjectMapperUtils.map(orderHeader, OrderHeaderPojo.class);
		return createDeleteUpdateResponse(orderHeaderPojo, "Order header created Successfully ");
	}

	private OrderHeaderPojoResponse createDeleteUpdateResponse(OrderHeaderPojo orderHeaderPojo, String message) {
		OrderHeaderPojoResponse orderHeaderPojoResponse = new OrderHeaderPojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessages = new ArrayList<>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessages.add(responseMessagePojo);
		orderHeaderPojoResponse.setOrderHeaderPojo(orderHeaderPojo);
		orderHeaderPojoResponse.setSuccessMessaages(successMessages);
		return orderHeaderPojoResponse;
	}

	public OrderHeaderPojoListResponse listAll() {
		OrderHeaderPojoListResponse orderHeaderPojoListResponse = new OrderHeaderPojoListResponse();
		List<OrderHeader> orderHeader = orderHeaderService.listAll();
		List<OrderHeaderPojo> orderHeaderPojo = ObjectMapperUtils.mapAll(orderHeader, OrderHeaderPojo.class);
		orderHeaderPojoListResponse.setOrderHeaderPojo(orderHeaderPojo);
		return orderHeaderPojoListResponse;
	}

	public OrderHeaderPojoResponse getOrderHeaderByid(Long id) {
		OrderHeaderPojoResponse orderPojoResponse = new OrderHeaderPojoResponse();
		OrderHeader orderHeader = orderHeaderService.getOrderyId(id);
		OrderHeaderPojo orderHeaderPojo = ObjectMapperUtils.map(orderHeader, OrderHeaderPojo.class);
		orderPojoResponse.setOrderHeaderPojo(orderHeaderPojo);
		return orderPojoResponse;
	}

	public OrderHeaderPojoResponse delete(long id) {
		orderHeaderService.deleteOrderHeader(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");

	}

	public OrderHeaderPojoResponse update(OrderHeaderPojo orderHeaderPojo) {
		OrderHeader orderHeader = orderHeaderService.getOrderyId(orderHeaderPojo.getId());
		ApproverHirarchy approverHirarchy=null;
		Set<ApproverHirarchy> approverHirarchy2=new HashSet<>();
		List<ApproverHirarchy> setApproverHirarchy = ObjectMapperUtils.mapAll(orderHeaderPojo.getApproverHirarchy(), ApproverHirarchy.class);
		for(ApproverHirarchy approverHirarchy1:setApproverHirarchy) {
			approverHirarchy = approverHirarchyService.create(approverHirarchy1);
			approverHirarchy2.add(approverHirarchy);
		}
		ObjectMapperUtils.map(orderHeaderPojo, orderHeader);
		orderHeader.setApproverHirarchy(approverHirarchy2);
		orderHeader = orderHeaderService.Update(orderHeader);
		orderHeaderPojo = ObjectMapperUtils.map(orderHeader, OrderHeaderPojo.class);
		return createDeleteUpdateResponse(orderHeaderPojo, "Updated successfully");
	}
}
