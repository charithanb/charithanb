package com.events.westernevents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.events.westernevents.repository.EventCitiesRepository;
import com.tourcoreservice.entity.events.EventCities;

@Service
public class EventCitiesService {

	@Autowired
	private EventCitiesRepository eRepository;
	
	public EventCities create(EventCities eCities) {
		return eRepository.save(eCities);
	}

	public EventCities getById(long id) {
		return eRepository.findById(id).get();
	}

	public List<EventCities> listAll() {
		return eRepository.findAll();
	}

	public void delete(long id) {
		eRepository.deleteById(id);
	}

	public EventCities Update(EventCities eCities) {
		return eRepository.save(eCities);
	}
}
