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

import com.events.westernevents.facad.EventCityLocationFacad;
import com.tourcoreservice.pojo.events.EventCityLocationPojo;
import com.tourcoreservice.response.events.EventCityLocationListResponse;
import com.tourcoreservice.response.events.EventCityLocationResponse;
import com.tourcoreservice.response.events.EventCityLocationSimpleListResponse;


@RestController
@RequestMapping("/EventCityLocation")
public class EventCityLocationController {
	@Autowired
	EventCityLocationFacad eCitiesFacad;

	@GetMapping
	public EventCityLocationListResponse getAll() {
		return eCitiesFacad.listAll();
	}
	
	@GetMapping("/simple")
	public EventCityLocationSimpleListResponse getAllWithoutpack() {
		return eCitiesFacad.SimpelistAll();
	}
	
	@GetMapping("/{id}")
	public EventCityLocationResponse get(@PathVariable long id) {
		return eCitiesFacad.getCities(id);
	}

	@PostMapping
	public EventCityLocationResponse create(@RequestBody EventCityLocationPojo ePojo) {
		return eCitiesFacad.saveCities(ePojo);
	}

	@PutMapping("/{id}")
	public EventCityLocationResponse update(@RequestBody EventCityLocationPojo ePojo, @PathVariable long id) {
		ePojo.setId(id);
		return eCitiesFacad.updateCities(ePojo);

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		eCitiesFacad.delete(id);
	}
}
