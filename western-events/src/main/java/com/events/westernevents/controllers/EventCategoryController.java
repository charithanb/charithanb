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

import com.events.westernevents.facad.EventCategoryFacad;
import com.tourcoreservice.pojo.events.EventCatogoryPojo;
import com.tourcoreservice.response.events.EventCategoryListResponse;
import com.tourcoreservice.response.events.EventCategoryNoImgListResponse;
import com.tourcoreservice.response.events.EventCategoryResponse;


@RestController
@RequestMapping("/EventCategory")
public class EventCategoryController {

	@Autowired
	EventCategoryFacad eCategoryFacad;

	@GetMapping
	public EventCategoryListResponse getAll() {
		return eCategoryFacad.listAll();
	}
	
	@GetMapping("/noimage")
	public EventCategoryNoImgListResponse getAllNoImage() {
		return eCategoryFacad.listAllNoImage();
	}
	
	@GetMapping("/{id}")
	public EventCategoryResponse get(@PathVariable long id) {
		return eCategoryFacad.getCategory(id);
	}

	@PostMapping
	public EventCategoryResponse create(@RequestBody EventCatogoryPojo ePojo) {
		return eCategoryFacad.saveCategory(ePojo);
	}

	@PutMapping("/{id}")
	public EventCategoryResponse update(@RequestBody EventCatogoryPojo ePojo, @PathVariable long id) {
		ePojo.setId(id);
		return eCategoryFacad.updateCategory(ePojo);

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		eCategoryFacad.delete(id);
	}
	
}
