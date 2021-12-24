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

import com.tour.facade.PlaceFacede;
import com.tourcoreservice.pojo.tourpackage.MainPlacePojo;
import com.tourcoreservice.pojo.tourpackage.PlacePojo;
import com.tourcoreservice.response.tourpackage.MainPlacePojoListResponse;
import com.tourcoreservice.response.tourpackage.MainPlacePojoResponse;
import com.tourcoreservice.response.tourpackage.PlacePojoListResponse;
import com.tourcoreservice.response.tourpackage.PlacePojoResponce;

@RestController
@RequestMapping("/place")
public class PlaceController {

	@Autowired
	PlaceFacede placefacede;

	@GetMapping
	public PlacePojoListResponse allPlaces() {
		return placefacede.listAllPlaces();
	}

	@GetMapping("/{id}")
	public PlacePojoResponce getPlace(@PathVariable long id) {
		return placefacede.getPlace(id);

	}

	@PostMapping
	public PlacePojoResponce create(@RequestBody PlacePojo place) {
		return placefacede.savePlace(place);
	}

	@PutMapping("/{id}")
	public PlacePojoResponce update(@RequestBody PlacePojo place, @PathVariable long id) {
		place.setId(id);
		return placefacede.updatePlace(place);

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		placefacede.deletePlace(id);
	}

	// main place apis
	@PostMapping("/mainplace")
	public MainPlacePojoResponse mainplaceCreae(@RequestBody MainPlacePojo mainPlacePojo) {
		return placefacede.mainplaceCreae(mainPlacePojo);
	}

	@GetMapping("/allmainplaces")
	public MainPlacePojoListResponse allmainPlaces() {
		return placefacede.allMainPlaces();

	}

	@PutMapping("/mainplace/update")
	public MainPlacePojoResponse updateMainPlace(@RequestBody MainPlacePojo mainPlacePojo ) {
		return placefacede.updateMainPlace(mainPlacePojo);
	}

	@DeleteMapping("/mainplace/{id}")
	public MainPlacePojoResponse deleteMainPlace(@PathVariable("id") long id){
		return placefacede.deleteMainPlace(id);
		
	}
}
