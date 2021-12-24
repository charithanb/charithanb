package com.tour.controller;

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

import com.tour.facade.Main_placeFacade;
import com.tour.facade.PlaceFacede;
import com.tourcoreservice.main_place.pojo.Main_placePojo;
import com.tourcoreservice.main_place.response.Main_placeListResponse;
import com.tourcoreservice.main_place.response.Main_placeResponse;
import com.tourcoreservice.tourpackage.pojo.PlacePojo;
import com.tourcoreservice.tourpackage.response.PlaceListResponse;
import com.tourcoreservice.tourpackage.response.PlaceResponce;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/place")
public class PlaceController {

	@Autowired
	PlaceFacede placefacede;

	@Autowired
	Main_placeFacade main_placeFacade;

	@GetMapping
	public PlaceListResponse allPlaces() {
		return placefacede.listAllPlaces();
	}

	@GetMapping("/{id}")
	public PlaceResponce getPlace(@PathVariable long id) {
		return placefacede.getPlace(id);

	}

	@PostMapping
	public PlaceResponce create(@RequestBody PlacePojo place) {
		return placefacede.savePlace(place);
	}

	@PutMapping("/{id}")
	public PlaceResponce update(@RequestBody PlacePojo place, @PathVariable long id) {
		place.setId(id);
		return placefacede.updatePlace(place);

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		placefacede.deletePlace(id);
	}

	// Main_place API's

	@GetMapping
	public Main_placeListResponse allMainPlaces() {
		return main_placeFacade.listAllMainPlaces();
	}

	@GetMapping("/{id}")
	public Main_placeResponse getMain_place(@PathVariable long id) {
		return main_placeFacade.getMain_place(id);

	}
	
	@PostMapping
	public Main_placeResponse create(@RequestBody Main_placePojo main_place) {
		return main_placeFacade.saveMain_place(main_place);
	}
	
	@PutMapping("/{id}")
	public Main_placeResponse update(@RequestBody Main_placePojo main_place, @PathVariable long id) {
		main_place.setId(id);
		return main_placeFacade.updateMain_Place(main_place);

	}
	
	@DeleteMapping("/{id}")
	public void delete1(@PathVariable long id) {
		main_placeFacade.deleteMain_Place(id);
	}

}
