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

import com.order.orderservice.facade.CustomisePackageHotelInfoFacade;
import com.tourcoreservice.pojo.orders.CustomisePackageHotelInfoPojo;
import com.tourcoreservice.response.orders.CustomisePackageHotelInfoPojoListResponse;
import com.tourcoreservice.response.orders.CustomisePackageHotelInfoPojoResponse;

@RestController
@RequestMapping("/customise-package-hotel-info")
public class CustomisePackageHotelInfoController {

	@Autowired
	private CustomisePackageHotelInfoFacade customisePackageHotelInfoFacade;

	@PostMapping
	public CustomisePackageHotelInfoPojoResponse createOrder(
			@RequestBody CustomisePackageHotelInfoPojo customisePackageHotelInfoPojo) {
		return customisePackageHotelInfoFacade.create(customisePackageHotelInfoPojo);

	}

	@GetMapping
	public CustomisePackageHotelInfoPojoListResponse getAllCustomisePackageHotelInfo() {
		return customisePackageHotelInfoFacade.listAll();
	}

	@GetMapping("/{id}")
	public CustomisePackageHotelInfoPojoResponse getCustomisePackageHotelInfoById(@PathVariable Long id) {
		return customisePackageHotelInfoFacade.getByid(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		customisePackageHotelInfoFacade.delete(id);
	}

	@PutMapping
	public CustomisePackageHotelInfoPojoResponse updateCustomisePackageHotelInfoById(
			@RequestBody CustomisePackageHotelInfoPojo customisePackageHotelInfoPojo) {
		return customisePackageHotelInfoFacade.update(customisePackageHotelInfoPojo);
	}
}
