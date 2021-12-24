package com.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tour.facade.InterNatPackageSuggestFacade;
import com.tourcoreservice.pojo.tourpackage.InterNatPackageSuggestPojo;
import com.tourcoreservice.response.tourpackage.InterNatPackageSuggestPojoListResponse;
import com.tourcoreservice.response.tourpackage.InterNatPackageSuggestPojoResponse;

@RestController
@RequestMapping("/InterNatPackagesuggest")
public class InterNatPackageSuggestController {
	
	@Autowired
	InterNatPackageSuggestFacade interNatPackageSuggestFacade ;

	@PostMapping
	public InterNatPackageSuggestPojoResponse create(@RequestBody InterNatPackageSuggestPojo packageSuggestPojo) {
		return interNatPackageSuggestFacade.create(packageSuggestPojo);
	}
	
	@GetMapping
	public InterNatPackageSuggestPojoListResponse getall() {
		return interNatPackageSuggestFacade.getAll();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		interNatPackageSuggestFacade.delete(id);
	}
	
	@PutMapping("/{id}")
	public InterNatPackageSuggestPojoResponse update(@RequestBody InterNatPackageSuggestPojo packageSuggestPojo, @PathVariable("id") long id) {
		packageSuggestPojo.setId(id);
		return interNatPackageSuggestFacade.update(packageSuggestPojo);
	}
}
