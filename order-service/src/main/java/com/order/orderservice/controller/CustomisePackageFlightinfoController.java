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

import com.order.orderservice.facade.CustomisePackageFlightinfoFacade;
import com.tourcoreservice.pojo.orders.CustomisePackageFlightinfoPojo;
import com.tourcoreservice.response.orders.CustomisePackageFlightinfoPojoListResponse;
import com.tourcoreservice.response.orders.CustomisePackageFlightinfoPojoResponse;

@RestController
@RequestMapping("/customise-package-flight-info")
public class CustomisePackageFlightinfoController {

	@Autowired
	private CustomisePackageFlightinfoFacade customisePackageFlightinfofacade;

	@PostMapping
	public CustomisePackageFlightinfoPojoResponse createCustomisePackageFlightinfo(
			@RequestBody CustomisePackageFlightinfoPojo customisePackageFlightinfoPojo) {
		return customisePackageFlightinfofacade.create(customisePackageFlightinfoPojo);

	}

	@GetMapping
	public CustomisePackageFlightinfoPojoListResponse getAllCustomisePackageFlightinfo() {
		return customisePackageFlightinfofacade.listAll();
	}

	@GetMapping("/{id}")
	public CustomisePackageFlightinfoPojoResponse getCustomisePackageFlightinfoById(@PathVariable Long id) {
		return customisePackageFlightinfofacade.getDataByid(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		customisePackageFlightinfofacade.delete(id);
	}

	@PutMapping
	public CustomisePackageFlightinfoPojoResponse updateCustomisePackageFlightinfoById(
			@RequestBody CustomisePackageFlightinfoPojo customisePackageFlightinfoPojo) {
		return customisePackageFlightinfofacade.update(customisePackageFlightinfoPojo);
	}

}