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

import com.events.westernevents.facad.EventThemesFacad;
import com.tourcoreservice.pojo.events.EventThemesPojo;
import com.tourcoreservice.response.events.EventThemeNoImageListResponse;
import com.tourcoreservice.response.events.EventsThemeListResponse;
import com.tourcoreservice.response.events.EventsThemeResponse;


@RestController
@RequestMapping("/EventThemes")
public class EventThemeController {

	@Autowired
	EventThemesFacad eThemesFacad;

	@GetMapping
	public EventsThemeListResponse getAll() {
		return eThemesFacad.listAll();
	}
	
	@GetMapping("/noimage")
	public EventThemeNoImageListResponse getAllNoImage() {
		return eThemesFacad.listAllNoImage();
	}

	@GetMapping("/{id}")
	public EventsThemeResponse get(@PathVariable long id) {
		return eThemesFacad.getTheme(id);
	}

	@PostMapping
	public EventsThemeResponse create(@RequestBody EventThemesPojo ePojo) {
		return eThemesFacad.saveTheme(ePojo);
	}

	@PutMapping("/{id}")
	public EventsThemeResponse update(@RequestBody EventThemesPojo ePojo, @PathVariable long id) {
		ePojo.setId(id);
		return eThemesFacad.updateBlog(ePojo);

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		eThemesFacad.delete(id);
	}
}
