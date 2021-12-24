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

import com.events.westernevents.facad.EventOrganiserFacad;
import com.tourcoreservice.pojo.events.EventOrganiserPojo;
import com.tourcoreservice.response.events.EventOrganiserListResponse;
import com.tourcoreservice.response.events.EventOrganiserResponse;


@RestController
@RequestMapping("/EventOrganiser")
public class EventOrganiserController {
	
	@Autowired
	EventOrganiserFacad eOrganiserFacad;

	@GetMapping
	public EventOrganiserListResponse getAll() {
		return eOrganiserFacad.listAll();
	}
	
	
	@GetMapping("/{id}")
	public EventOrganiserResponse get(@PathVariable long id) {
		return eOrganiserFacad.getOrganiser(id);
	}

	@PostMapping
	public EventOrganiserResponse create(@RequestBody EventOrganiserPojo ePojo) {
		return eOrganiserFacad.saveOrganiser(ePojo);
	}

	@PutMapping("/{id}")
	public EventOrganiserResponse update(@RequestBody EventOrganiserPojo ePojo, @PathVariable long id) {
		ePojo.setId(id);
		return eOrganiserFacad.updateOrganiser(ePojo);

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		eOrganiserFacad.delete(id);
	}
	
}
