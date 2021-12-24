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

import com.events.westernevents.facad.MainEventPartiesFacade;
import com.tourcoreservice.pojo.events.MainEventsPartyPojo;
import com.tourcoreservice.response.events.MainEventsPartyResponse;
import com.tourcoreservice.response.events.MainEventsPartyResponseList;

import javassist.bytecode.stackmap.BasicBlock.Catch;


@RestController
@RequestMapping("/MainEventParties")
public class MainEventsPartiesController {
	
	@Autowired
	MainEventPartiesFacade mainEventPartiesFacade;
	
	@GetMapping
	public MainEventsPartyResponseList getAll() {
		return mainEventPartiesFacade.listAllParties();
	}

	@GetMapping("/{id}")
	public MainEventsPartyResponse get(@PathVariable long id) {
		return mainEventPartiesFacade.getParty(id);
	}
	
	@PostMapping
	public MainEventsPartyResponse create(@RequestBody MainEventsPartyPojo partyPojo) {
		return mainEventPartiesFacade.saveparty(partyPojo);
	}

	@PutMapping("/{id}")
	public MainEventsPartyResponse update(@RequestBody MainEventsPartyPojo partyPojo, @PathVariable long id) {
		partyPojo.setId(id);
		return mainEventPartiesFacade.updateCategory(partyPojo);

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		mainEventPartiesFacade.delete(id);
	}
}
