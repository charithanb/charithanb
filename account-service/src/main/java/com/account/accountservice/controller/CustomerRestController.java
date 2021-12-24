package com.account.accountservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.accountservice.facade.CustomerFacade;
import com.tourcoreservice.pojo.account.CustomerPojo;
import com.tourcoreservice.response.account.CustomerPojoListResponse;
import com.tourcoreservice.response.account.CustomerPojoResponse;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {

	@Autowired
	CustomerFacade customerFacade;

	@PostMapping
	public CustomerPojoResponse create(@RequestBody CustomerPojo customerPojo) {
		return customerFacade.create(customerPojo);

	}

	@GetMapping
	public CustomerPojoListResponse get() {
		return customerFacade.get();

	}

	@PutMapping
	public CustomerPojoResponse update(@RequestBody CustomerPojo customerPojo) {
		return customerFacade.update(customerPojo);
	}

	@DeleteMapping("/{id}")
	public CustomerPojoResponse delete(@PathVariable("id") long id) {
		return customerFacade.delete(id);

	}
	
	@GetMapping("/{customerid}")
	public CustomerPojoResponse getCustomerById(@PathVariable("customerid") long customerId) {
		return customerFacade.getCustomerById(customerId);
		
	}

}
