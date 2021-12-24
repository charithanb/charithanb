package com.events.westernevents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.events.westernevents.repository.EventCitiesLocationRepository;
import com.events.westernevents.repository.EventCitiesRepository;
import com.tourcoreservice.entity.events.EventCities;
import com.tourcoreservice.entity.events.EventCityLocation;

@Service
public class EventCityLocationService {

	@Autowired
	private EventCitiesLocationRepository eRepository;
	
	public EventCityLocation create(EventCityLocation eCities) {
		return eRepository.save(eCities);
	}

	public EventCityLocation getById(long id) {
		return eRepository.findById(id).get();
	}

	public List<EventCityLocation> listAll() {
		return eRepository.findAll();
	}

	public void delete(long id) {
		eRepository.deleteById(id);
	}

	public EventCityLocation Update(EventCityLocation eCities) {
		return eRepository.save(eCities);
	}
}
