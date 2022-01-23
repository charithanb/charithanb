package com.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.repository.MainPlaceRepository;
import com.tour.repository.PlaceRepositoty;
import com.tourcoreservice.entity.MainPlace;
import com.tourcoreservice.entity.Place;

@Service
public class PlaceService {

	@Autowired
	private PlaceRepositoty placeRepositoty;

	@Autowired
	private MainPlaceRepository mainPlaceRepository;

	public List<Place> listAllPlace() {
		return placeRepositoty.findAll();
	}

	public Place savePlace(Place place) {
		return placeRepositoty.save(place);
	}

	public Place UpdatePlace(Place place) {
		return placeRepositoty.save(place);
	}

	public Place getPlaceById(long id) {
		return placeRepositoty.findById(id);
	}

	public void deletePlace(long id) {
		placeRepositoty.deleteById(id);
	}

	public MainPlace saveMainPlace(MainPlace mainplace) {
		return mainPlaceRepository.save(mainplace);
	}

	public List<MainPlace> allMainPlaces() {
		return mainPlaceRepository.findAll();
	}

	public MainPlace getMainPlaceById(long id) {
		return mainPlaceRepository.findByid(id);
	}

	public MainPlace updateMainPlace(MainPlace mainPlace) {
		return mainPlaceRepository.save(mainPlace);
	}

	public void deleteMainPlace(MainPlace mainPlace) {
		mainPlaceRepository.delete(mainPlace);
		
	}
}
