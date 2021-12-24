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

import com.events.westernevents.facad.EventArtistFacad;
import com.tourcoreservice.pojo.events.EventArtistPojo;
import com.tourcoreservice.response.events.EventArstistResponse;
import com.tourcoreservice.response.events.EventArtistListResponse;
import com.tourcoreservice.response.events.EventArtsitNoImageListResponse;

@RestController
@RequestMapping("/EventArtist")
public class EventArtistController {

	@Autowired
	EventArtistFacad eArtistFacad;

	@GetMapping
	public EventArtistListResponse getAll() {
		return eArtistFacad.listAll();
	}
	
	@GetMapping("/noimage")
	public EventArtsitNoImageListResponse getAllNoImage() {
		return eArtistFacad.listAllNoImage();
	}

	@GetMapping("/{id}")
	public EventArstistResponse get(@PathVariable long id) {
		return eArtistFacad.getArtist(id);
	}

	@PostMapping
	public EventArstistResponse create(@RequestBody EventArtistPojo ePojo) {
		return eArtistFacad.saveArtist(ePojo);
	}

	@PutMapping("/{id}")
	public EventArstistResponse update(@RequestBody EventArtistPojo ePojo, @PathVariable long id) {
		ePojo.setId(id);
		return eArtistFacad.updateArtist(ePojo);

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		eArtistFacad.delete(id);
	}
}
