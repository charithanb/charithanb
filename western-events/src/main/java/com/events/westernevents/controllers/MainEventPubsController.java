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
import com.events.westernevents.facad.MainEventPubsFacad;
import com.tourcoreservice.pojo.events.MainEventPubsPojo;
import com.tourcoreservice.response.events.MainEventPubsListResponse;
import com.tourcoreservice.response.events.MainEventPubsResponse;


@RestController
@RequestMapping("/MainEventPubs")
public class MainEventPubsController {

	@Autowired
	MainEventPubsFacad mEventPubsFacad;
	
	@GetMapping
	public MainEventPubsListResponse getAll() {
		return mEventPubsFacad.listAllPubs();
	}

	@GetMapping("/{id}")
	public MainEventPubsResponse get(@PathVariable long id) {
		return mEventPubsFacad.getPub(id);
	}
	
	@PostMapping
	public MainEventPubsResponse create(@RequestBody MainEventPubsPojo mEventPubsPojo) {
		return mEventPubsFacad.savepub(mEventPubsPojo);
	}

	@PutMapping("/{id}")
	public MainEventPubsResponse update(@RequestBody MainEventPubsPojo mEventPubsPojo , @PathVariable long id) {
		mEventPubsPojo.setId(id);
		return mEventPubsFacad.updatePub(mEventPubsPojo);

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		mEventPubsFacad.delete(id);
	}
	
}
