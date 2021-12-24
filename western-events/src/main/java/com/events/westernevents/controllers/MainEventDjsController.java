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
import com.events.westernevents.facad.MainEventDjsFacad;
import com.tourcoreservice.pojo.events.MainEventDjsPojo;
import com.tourcoreservice.response.events.MainEventDjsListResponse;
import com.tourcoreservice.response.events.MainEventDjsResponse;


@RestController
@RequestMapping("/MainEventDjs")
public class MainEventDjsController {

	@Autowired
	MainEventDjsFacad mEventDjsFacad;
	
	@GetMapping
	public MainEventDjsListResponse getAll() {
		return mEventDjsFacad.listAll();
	}

	@GetMapping("/{id}")
	public MainEventDjsResponse get(@PathVariable long id) {
		return mEventDjsFacad.getDj(id);
	}
	
	@PostMapping
	public MainEventDjsResponse create(@RequestBody MainEventDjsPojo mDjsPojo) {
		return mEventDjsFacad.saveDj(mDjsPojo);
	}

	@PutMapping("/{id}")
	public MainEventDjsResponse update(@RequestBody MainEventDjsPojo mDjsPojo , @PathVariable long id) {
		mDjsPojo.setId(id);
		return mEventDjsFacad.updateDj(mDjsPojo);

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		mEventDjsFacad.delete(id);
	}
	
}
