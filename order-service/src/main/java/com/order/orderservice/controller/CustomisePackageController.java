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

import com.order.orderservice.facade.CustomisePackageFacade;
import com.tourcoreservice.pojo.orders.CustomisePackagePojo;
import com.tourcoreservice.response.orders.CustomisePackagePojoListResponse;
import com.tourcoreservice.response.orders.CustomisePackagePojoRespone;

@RestController
@RequestMapping("/custamise-package")
public class CustomisePackageController {

	@Autowired
	private CustomisePackageFacade customisePackageFacade;

	@PostMapping
	public CustomisePackagePojoRespone createCustomisePackage(@RequestBody CustomisePackagePojo customisePackagePojo) {
		return customisePackageFacade.create(customisePackagePojo);

	}

	@GetMapping
	public CustomisePackagePojoListResponse getAllCustomisePackage() {
		return customisePackageFacade.listAll();
	}

	@GetMapping("/{id}")
	public CustomisePackagePojoRespone getCustomisePackageById(@PathVariable Long id) {
		return customisePackageFacade.getData(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		customisePackageFacade.delete(id);
	}

	@PutMapping
	public CustomisePackagePojoRespone updateCustomisePackageById(@RequestBody CustomisePackagePojo customisePackagePojo) {
		return customisePackageFacade.update(customisePackagePojo);
	}

}