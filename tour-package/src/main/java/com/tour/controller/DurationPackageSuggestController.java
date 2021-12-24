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

import com.tour.facade.DurationPackageSuggestFacade;
import com.tourcoreservice.pojo.tourpackage.DurationPackageSuggestPojo;
import com.tourcoreservice.response.tourpackage.DurationPackageSuggestPojoResponse;
import com.tourcoreservice.response.tourpackage.DurationSuggestPackagePojoListResponse;

@RestController
@RequestMapping("/durationPackageSuggest")
public class DurationPackageSuggestController {
	
	@Autowired
	private DurationPackageSuggestFacade durationFacade;
	@PostMapping
	public DurationPackageSuggestPojoResponse create(@RequestBody DurationPackageSuggestPojo durationPojo) {
		return durationFacade.create(durationPojo);
	}
	
	@GetMapping("/{id}")
	public DurationPackageSuggestPojoResponse get(@PathVariable long id) {
		return durationFacade.get(id);
	}
	
	@GetMapping
	public DurationSuggestPackagePojoListResponse getAll() {
		return durationFacade.listAll();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		durationFacade.delete(id);
	}
	
	@PutMapping("/{id}")
	public DurationPackageSuggestPojoResponse update(@RequestBody DurationPackageSuggestPojo durationPojo,
			@PathVariable("id") long id) {
		durationPojo.setId(id);
		return durationFacade.update(durationPojo);
	}

}
