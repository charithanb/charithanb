package com.events.westernevents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.events.westernevents.repository.EventArtistRepository;
import com.tourcoreservice.entity.events.EventArtist;

@Service
public class EventArtistService {

	@Autowired
	private EventArtistRepository eArtistRepository;
	
	public EventArtist create(EventArtist eThemes) {
		return eArtistRepository.save(eThemes);
	}

	public EventArtist getById(long id) {
		return eArtistRepository.findById(id).get();
	}

	public List<EventArtist> listAll() {
		return eArtistRepository.findAll();
	}

	public void delete(long id) {
		eArtistRepository.deleteById(id);
	}

	public EventArtist Update(EventArtist eThemes) {
		return eArtistRepository.save(eThemes);
	}
}
