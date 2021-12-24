package com.events.westernevents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.events.westernevents.repository.EventPackageRepository;
import com.tourcoreservice.entity.events.EventPackages;

@Service
public class EventPackageService {

	@Autowired
	private EventPackageRepository eRepository;
	
	public EventPackages create(EventPackages ePackages) {
		return eRepository.save(ePackages);
	}

	public EventPackages getById(long id) {
		return eRepository.findById(id).get();
	}

	public List<EventPackages> listAll() {
		return eRepository.findAll();
	}

	public void delete(long id) {
		eRepository.deleteById(id);
	}

	public EventPackages Update(EventPackages ePackages) {
		return eRepository.save(ePackages);
	}
}
