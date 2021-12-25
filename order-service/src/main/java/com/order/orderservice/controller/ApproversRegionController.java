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

import com.order.orderservice.facade.ApproversRegionFacade;
import com.tourcoreservice.pojo.orders.ApproverRegionPojo;
import com.tourcoreservice.response.orders.ApproverRegionPojoListResponse;
import com.tourcoreservice.response.orders.ApproverRegionPojoResponse;

@RestController
@RequestMapping("/approvers-region")
public class ApproversRegionController {

	@Autowired
	private ApproversRegionFacade approversRegionFacade;

	@PostMapping
	public ApproverRegionPojoResponse createApproversRegion(@RequestBody ApproverRegionPojo approverRegionPojo) {
		return approversRegionFacade.create(approverRegionPojo);

	}

	@GetMapping
	public ApproverRegionPojoListResponse getAllOrders() {
		return approversRegionFacade.listAll();
	}

	@GetMapping("/{id}")
	public ApproverRegionPojoResponse getApproversRegionById(@PathVariable Long id) {
		return approversRegionFacade.getByid(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		approversRegionFacade.delete(id);
	}

	@PutMapping
	public ApproverRegionPojoResponse updateApproversRegionById(@RequestBody ApproverRegionPojo approverRegionPojo) {
		return approversRegionFacade.update(approverRegionPojo);
	}

	/*
	 * @GetMapping("/{regionName}") public ApproversRegionPojoResponse
	 * getApproverByName(@RequestParam String regionName) { return
	 * approversRegionFacade.getApproversByName(regionName);
	 * 
	 * }
	 */
	@GetMapping("/approvers-by-region-name")
	public ApproverRegionPojoResponse getApproverByName(@RequestBody ApproverRegionPojo approverRegionPojo) {
		return approversRegionFacade.getApproversByRegionName(approverRegionPojo);

	}

}
