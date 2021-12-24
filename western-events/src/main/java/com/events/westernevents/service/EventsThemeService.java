package com.events.westernevents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.events.westernevents.repository.EventsThemeRepository;
import com.tourcoreservice.entity.events.EventThemes;

@Service
public class EventsThemeService {

	@Autowired
	private EventsThemeRepository eThemeRepository;
	
	public EventThemes create(EventThemes eThemes) {
		return eThemeRepository.save(eThemes);
	}

	public EventThemes getById(long id) {
		return eThemeRepository.findById(id).get();
	}

	public List<EventThemes> listAll() {
		return eThemeRepository.findAll();
	}

	

	public void delete(long id) {
		eThemeRepository.deleteById(id);

	}

	public EventThemes Update(EventThemes eThemes) {
		return eThemeRepository.save(eThemes);
	}

}
