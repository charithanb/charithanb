package com.events.westernevents.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.events.westernevents.facad.EventCitiesFacad;
import com.tourcoreservice.pojo.events.EventCitiesPojo;
import com.tourcoreservice.response.events.EventCitiesListResponse;
import com.tourcoreservice.response.events.EventCitiesResponse;
import com.tourcoreservice.response.events.EventCitiesSimpleListResponse;


@RestController
@RequestMapping("/EventCities")
public class EventCitiesController {

	@Autowired
	EventCitiesFacad eCitiesFacad;

	@GetMapping
	public EventCitiesListResponse getAll() {
		return eCitiesFacad.listAll();
	}
	
	@GetMapping("/simple")
	public EventCitiesSimpleListResponse getAllWithoutpack() {
		return eCitiesFacad.SimpelistAll();
	}
	@GetMapping("/{id}")
	public EventCitiesResponse get(@PathVariable long id) {
		return eCitiesFacad.getCities(id);
	}

	@PostMapping
	public EventCitiesResponse create(@RequestBody EventCitiesPojo ePojo) {
		return eCitiesFacad.saveCities(ePojo);
	}

	@PutMapping("/{id}")
	public EventCitiesResponse update(@RequestBody EventCitiesPojo ePojo, @PathVariable long id) {
		ePojo.setId(id);
		return eCitiesFacad.updateCities(ePojo);

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		eCitiesFacad.delete(id);
	}
}
