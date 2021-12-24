package com.events.westernevents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.events.westernevents.repository.MainEventNightlifeRepository;
import com.tourcoreservice.entity.events.MainEventsNightlifeEntity;

@Service
public class MainEventNightlifeService {

	@Autowired
	private MainEventNightlifeRepository mainEventNightlifeRepository;
	
	public MainEventsNightlifeEntity create(MainEventsNightlifeEntity mainEventsNightlifeEntity) {
		return mainEventNightlifeRepository.save(mainEventsNightlifeEntity);
	}

	public MainEventsNightlifeEntity getById(long id) {
		return mainEventNightlifeRepository.findById(id).get();
	}

	public List<MainEventsNightlifeEntity> listAll() {
		return mainEventNightlifeRepository.findAll();
	}

	public void delete(long id) {
		mainEventNightlifeRepository.deleteById(id);

	}

	public MainEventsNightlifeEntity Update(MainEventsNightlifeEntity mainEventsNightlifeEntity) {
		return mainEventNightlifeRepository.save(mainEventsNightlifeEntity);
	}

	
}
