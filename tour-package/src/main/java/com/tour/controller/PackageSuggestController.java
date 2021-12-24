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

import com.tour.facade.PackageSuggestFacade;
import com.tourcoreservice.pojo.tourpackage.PackageSuggestPojo;
import com.tourcoreservice.response.tourpackage.PackageSuggestPojoListResponse;
import com.tourcoreservice.response.tourpackage.PackageSuggestPojoResponse;

@RestController
@RequestMapping("/packagesuggest")

public class PackageSuggestController {

	@Autowired
	PackageSuggestFacade packageSuggestFacade;

	@PostMapping
	public PackageSuggestPojoResponse create(@RequestBody PackageSuggestPojo packageSuggestPojo) {
		return packageSuggestFacade.create(packageSuggestPojo);
	}

	@GetMapping("/{id}")
	public PackageSuggestPojoResponse get(@PathVariable long id) {
		return packageSuggestFacade.get(id);
		}
	
	@GetMapping
	public PackageSuggestPojoListResponse getAll() {
		return packageSuggestFacade.listAll();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		packageSuggestFacade.delete(id);
	}
	
	@PutMapping("/{id}")
	public PackageSuggestPojoResponse update(@RequestBody PackageSuggestPojo packageSuggestPojo, @PathVariable("id") long id) {
		packageSuggestPojo.setId(id);
		return packageSuggestFacade.update(packageSuggestPojo);
	}
}
