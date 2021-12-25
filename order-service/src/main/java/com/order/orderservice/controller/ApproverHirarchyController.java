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

import com.order.orderservice.facade.ApproverHirarchyFacade;
import com.tourcoreservice.pojo.orders.ApproverHirarchyPojo;
import com.tourcoreservice.response.orders.ApproverHirarchyPojoListResponse;
import com.tourcoreservice.response.orders.ApproverHirarchyPojoResponse;

@RestController
@RequestMapping("/approver-hirarchy")
public class ApproverHirarchyController {

	@Autowired
	private ApproverHirarchyFacade approverHirarchyFacade;

	@PostMapping
	public ApproverHirarchyPojoResponse createApproverHirarchy(@RequestBody ApproverHirarchyPojo approverHirarchyPojo) {
		return approverHirarchyFacade.create(approverHirarchyPojo);

	}

	@GetMapping
	public ApproverHirarchyPojoListResponse getAllApproverHirarchy() {
		return approverHirarchyFacade.listAll();
	}

	@GetMapping("/{id}")
	public ApproverHirarchyPojoResponse getApproverHirarchyById(@PathVariable Long id) {
		return approverHirarchyFacade.getApproverHirarchyByid(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		approverHirarchyFacade.delete(id);
	}

	@PutMapping
	public ApproverHirarchyPojoResponse updateApproverHirarchyById(
			@RequestBody ApproverHirarchyPojo approverHirarchyPojo) {
		return approverHirarchyFacade.update(approverHirarchyPojo);
	}
}
