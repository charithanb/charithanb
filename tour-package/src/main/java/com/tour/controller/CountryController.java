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

import com.tour.facade.CountryFacade;
import com.tourcoreservice.pojo.tourpackage.CountryPojo;
import com.tourcoreservice.response.tourpackage.CountryPojoListResponse;
import com.tourcoreservice.response.tourpackage.CountryPojoResponse;

@RestController
@RequestMapping("/country")
public class CountryController {

	@Autowired
	private CountryFacade countryFacade;

	// Create Country
	@PostMapping
	public CountryPojoResponse createCountry(@RequestBody CountryPojo country) {
		return countryFacade.saveCountry(country);
	}

	// List Country by ID
	@GetMapping("/{id}")
	public CountryPojoResponse getCountryById(@PathVariable Long id) {
		return countryFacade.getCountry(id);
	}

	// List all countries
	@GetMapping
	public CountryPojoListResponse getAllCountries() {
		return countryFacade.listAllCountries();
	}

	// Update Country by ID
	@PutMapping
	public CountryPojoResponse updateCountryById(@RequestBody CountryPojo country) {
		return countryFacade.updateCountry(country);
	}

	// Delete Country by ID
	@DeleteMapping("/{id}")
	public void deleteCountryById(@PathVariable long id) {
		countryFacade.deleteCountry(id);
	}
}
