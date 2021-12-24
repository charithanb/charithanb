package com.account.accountservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.account.accountservice.facade.AddressFacade;
import com.tourcoreservice.account.pojo.AddressPojo;
import com.tourcoreservice.account.response.AddressPojoResponse;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/address")
public class AddressRestController {
	
	@Autowired
	private AddressFacade addressFacade;
	
	@PostMapping
	public AddressPojoResponse create(@RequestBody AddressPojo adressPojo) {
		return addressFacade.create(adressPojo);
		
	}

}
