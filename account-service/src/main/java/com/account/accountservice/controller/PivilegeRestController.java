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
import com.account.accountservice.facade.PrivilegeFacade;
import com.tourcoreservice.pojo.account.PrivilegePojo;
import com.tourcoreservice.response.account.PrivilegePojoListResponse;
import com.tourcoreservice.response.account.PrivilegePojoResponse;

@RestController
@RequestMapping("/privilege")
public class PivilegeRestController {
	
	@Autowired
	PrivilegeFacade privilegeFacade;
	
	@PostMapping
	public PrivilegePojoResponse create(@RequestBody PrivilegePojo privilegePojo) {
		return privilegeFacade.create(privilegePojo);
	}
	
	@GetMapping
	public PrivilegePojoListResponse allPrivileges() {
		return privilegeFacade.getAll();
	}
	
	@PutMapping
	public PrivilegePojoResponse update(@RequestBody PrivilegePojo privilegePojo)
	{
		return privilegeFacade.update(privilegePojo);
		
	}
	
	@DeleteMapping("/{id}")
	public PrivilegePojoResponse delete(@PathVariable("id") long id) {
		return privilegeFacade.delete(id);	
	}
	
	@GetMapping("privilege/{id}")
	public PrivilegePojoResponse getPrivilegeById(@PathVariable("id") long id) {
		return privilegeFacade.getPrivilegeById(id);
		
	}
	
}
