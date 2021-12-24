package com.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.repository.CountryRepository;
import com.tourcoreservice.entity.Country;

@Service
public class CountryServices {

	@Autowired
	private CountryRepository countryRepository;

	// To create new country
	public Country saveCountry(Country country) {
		return countryRepository.save(country);
	}

	// To fetch all countries list
	public List<Country> listAllCountries() {
		return countryRepository.findAll();
	}

	// To fetch a country details by id
	public Country getCountryById(long id) {
		return countryRepository.findById(id).get();
	}

	// To update Country
	public Country updateCountry(Country country) {
		return countryRepository.save(country);
	}

	// Delete country by ID
	public void deleteCountry(long id) {
		countryRepository.deleteById(id);
	}
	
	public void save(Country country) {
		countryRepository.save(country);
	}

	public Country findCountryByName(String name) {
		// TODO Auto-generated method stub
		return countryRepository.findByName(name);
	}
}
