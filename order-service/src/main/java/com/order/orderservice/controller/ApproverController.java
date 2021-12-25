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

import com.order.orderservice.facade.ApproverFacade;
import com.tourcoreservice.pojo.account.UserPojo;
import com.tourcoreservice.pojo.orders.ApproverPojo;
import com.tourcoreservice.response.orders.ApproverPojoListResponse;
import com.tourcoreservice.response.orders.ApproverPojoResponse;

@RestController
@RequestMapping("/approver")
public class ApproverController {

	@Autowired
	private ApproverFacade approverFacade;

	@PostMapping
	public ApproverPojoResponse createApprover(@RequestBody ApproverPojo approverPojo) {
		return approverFacade.create(approverPojo);

	}

	@GetMapping
	public ApproverPojoListResponse getAllApprover() {
		return approverFacade.listAll();
	}

	@GetMapping("/{id}")
	public ApproverPojoResponse getApproverById(@PathVariable Long id) {
		return approverFacade.getByid(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		approverFacade.delete(id);
	}

	@PutMapping
	public ApproverPojoResponse updateById(@RequestBody ApproverPojo approverPojo) {
		return approverFacade.update(approverPojo);
	}

	@GetMapping("/employee/{id}")
	public UserPojo getApproverByEmployeeId(@PathVariable long id) {
		return approverFacade.findById(id);
	}

}
