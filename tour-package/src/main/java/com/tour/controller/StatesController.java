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

import com.tour.facade.StatesFacade;
import com.tourcoreservice.pojo.tourpackage.StatesPojo;
import com.tourcoreservice.response.tourpackage.StatesPojoListResponse;
import com.tourcoreservice.response.tourpackage.StatesPojoResponse;

@RestController
@RequestMapping("/states")
public class StatesController {

	@Autowired
	StatesFacade statesFacade;

	// Create States
	@PostMapping
	public StatesPojoResponse createState(@RequestBody StatesPojo state) {
		return statesFacade.saveState(state);
	}

	// List all States
	@GetMapping
	public StatesPojoListResponse getAllStates() {
		return statesFacade.listAllStates();
	}

	// List State by ID
	@GetMapping("/{id}")
	public StatesPojoResponse getStateById(@PathVariable Long id) {
		return statesFacade.getState(id);
	}

	// Update States 
	@PutMapping
	public StatesPojoResponse updateStateById(@RequestBody StatesPojo state) {
		return statesFacade.updateState(state);
	}

	// Delete States by ID
	@DeleteMapping("/{id}")
	public void deleteStateById(@PathVariable long id) {
		statesFacade.deleteState(id);
	}
}
