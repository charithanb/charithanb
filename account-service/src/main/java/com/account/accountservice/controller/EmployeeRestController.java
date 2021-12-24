package com.account.accountservice.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.accountservice.facade.EmployeeFacade;
import com.tourcoreservice.pojo.account.EmployeePojo;
import com.tourcoreservice.response.account.EmployeePojoListResponse;
import com.tourcoreservice.response.account.EmployeePojoResponse;


@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@Autowired
	EmployeeFacade employeeFacade;

	
	@PostMapping
	public EmployeePojoResponse create(@RequestBody EmployeePojo employeePojo) {
		return employeeFacade.create(employeePojo);

	}

	@GetMapping
	public EmployeePojoListResponse getAll() {
		return employeeFacade.getAll();

	}

	@PutMapping
	public EmployeePojoResponse update(@RequestBody EmployeePojo employeePojo) {
		return employeeFacade.update(employeePojo);

	}

	@DeleteMapping("/{id}")
	public EmployeePojoResponse delete(@PathVariable("id") long Id) {
		return employeeFacade.delete(Id);

	}
	
	@GetMapping("{employeeid}")
	public EmployeePojoResponse getEmployeeById(@PathVariable("employeeid") long employeeId) {
		return employeeFacade.getEmployeeById(employeeId);
		
	}
	
	

}
