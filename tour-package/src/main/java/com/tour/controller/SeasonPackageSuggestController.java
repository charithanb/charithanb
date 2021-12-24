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

import com.tour.facade.SeasonPackageSuggestFacade;
import com.tourcoreservice.pojo.tourpackage.SeasonPackageSuggestPojo;
import com.tourcoreservice.response.tourpackage.SeasonPackageSuggestPojoListResponse;
import com.tourcoreservice.response.tourpackage.SeasonPackageSuggestPojoResponse;

@RestController
@RequestMapping("/seasonPackageSuggest")
public class SeasonPackageSuggestController {

	@Autowired
	SeasonPackageSuggestFacade seasonFacade;

	@PostMapping
	public SeasonPackageSuggestPojoResponse create(@RequestBody SeasonPackageSuggestPojo seasonPojo) {
		return seasonFacade.create(seasonPojo);
	}

	@GetMapping("/{id}")
	public SeasonPackageSuggestPojoResponse get(@PathVariable long id) {
		return seasonFacade.get(id);
	}

	@GetMapping
	public SeasonPackageSuggestPojoListResponse getAll() {
		return seasonFacade.listAll();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		seasonFacade.delete(id);
	}

	@PutMapping("/{id}")
	public SeasonPackageSuggestPojoResponse update(@RequestBody SeasonPackageSuggestPojo seasonPojo, @PathVariable("id") long id) {
		seasonPojo.setId(id);
		return seasonFacade.update(seasonPojo);
	}

}
