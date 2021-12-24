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

import com.events.westernevents.facad.EventsBannerFacad;
import com.tourcoreservice.pojo.events.EventbannerPojo;
import com.tourcoreservice.response.events.EventsBannerListResponse;
import com.tourcoreservice.response.events.EventsBannerResponse;


@RestController
@RequestMapping("/EventBanners")
public class EventBannerController {

	@Autowired
	EventsBannerFacad eFacad;

	@GetMapping
	public EventsBannerListResponse getAll() {
		return eFacad.listAll();
	}
	
	
	@GetMapping("/{id}")
	public EventsBannerResponse get(@PathVariable long id) {
		return eFacad.getBanner(id);
	}

	@PostMapping
	public EventsBannerResponse create(@RequestBody EventbannerPojo ePojo) {
		return eFacad.saveBanner(ePojo);
	}

	@PutMapping("/{id}")
	public EventsBannerResponse update(@RequestBody EventbannerPojo ePojo, @PathVariable long id) {
		ePojo.setId(id);
		return eFacad.updateBanner(ePojo);

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		eFacad.delete(id);
	}
}
