package com.events.westernevents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.events.westernevents.repository.MainEventPartiesRepository;
import com.tourcoreservice.entity.events.MainEventsPartiesEntity;




@Service
public class MainEventPartiesService {

	@Autowired
	private MainEventPartiesRepository mainEventPartiesRepository;
	
	public MainEventsPartiesEntity create(MainEventsPartiesEntity mainEventsPartie) {
		return mainEventPartiesRepository.save(mainEventsPartie);
	}

	public MainEventsPartiesEntity getById(long id) {
		return mainEventPartiesRepository.findById(id).get();
	}

	public List<MainEventsPartiesEntity> listAll() {
		return mainEventPartiesRepository.findAll();
	}

	public void delete(long id) {
		mainEventPartiesRepository.deleteById(id);

	}

	public MainEventsPartiesEntity Update(MainEventsPartiesEntity mainEventsParties) {
		return mainEventPartiesRepository.save(mainEventsParties);
	}

	
	
}
