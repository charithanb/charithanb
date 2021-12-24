package com.events.westernevents.controllers;

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

import com.events.westernevents.facad.EventPackageFacad;
import com.tourcoreservice.pojo.events.EventPackagePojo;
import com.tourcoreservice.response.events.EventPackageListResponse;
import com.tourcoreservice.response.events.EventPackageResponse;


@RestController
@RequestMapping("/EventPackage")
public class EventPackageController {

	@Autowired
	EventPackageFacad eFacad;

	@GetMapping
	public EventPackageListResponse getAll() {
		return eFacad.listAll();
	}
	
	
	@GetMapping("/{id}")
	public EventPackageResponse get(@PathVariable long id) {
		return eFacad.getPackage(id);
	}

	@PostMapping
	public EventPackageResponse create(@RequestBody EventPackagePojo ePojo) {
		return eFacad.savePackage(ePojo);
	}

	@PutMapping("/{id}")
	public EventPackageResponse update(@RequestBody EventPackagePojo ePojo, @PathVariable long id) {
		ePojo.setId(id);
		return eFacad.updatePackage(ePojo);

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		eFacad.delete(id);
	}
}
