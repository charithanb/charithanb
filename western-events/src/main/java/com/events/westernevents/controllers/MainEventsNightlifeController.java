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

import com.events.westernevents.facad.MainEventNightlifeFacade;
import com.tourcoreservice.pojo.events.MainEventsNightlifePojo;
import com.tourcoreservice.response.events.MainEventNightlifeResponse;
import com.tourcoreservice.response.events.MainEventNightlifeResponseList;


@RestController
@RequestMapping("/MainEventNightlife")
public class MainEventsNightlifeController {

	@Autowired
	MainEventNightlifeFacade mainEventNightlifeFacade;
	
	@GetMapping
	public MainEventNightlifeResponseList getAll() {
		return mainEventNightlifeFacade.listAll();
	}

	@GetMapping("/{id}")
	public MainEventNightlifeResponse get(@PathVariable long id) {
		return mainEventNightlifeFacade.getNightlife(id);
	}
	
	@PostMapping
	public MainEventNightlifeResponse create(@RequestBody MainEventsNightlifePojo mEventsNightlifePojo) {
		return mainEventNightlifeFacade.saveNightlife(mEventsNightlifePojo);
	}

	@PutMapping("/{id}")
	public MainEventNightlifeResponse update(@RequestBody MainEventsNightlifePojo nightlifePojo, @PathVariable long id) {
		nightlifePojo.setId(id);
		return mainEventNightlifeFacade.updateNightlife(nightlifePojo);

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		mainEventNightlifeFacade.delete(id);
	}
	
}
