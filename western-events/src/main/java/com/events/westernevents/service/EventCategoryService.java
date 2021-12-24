package com.events.westernevents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.events.westernevents.repository.EventCategoryRepository;
import com.tourcoreservice.entity.events.EventCatogory;

@Service
public class EventCategoryService {

	@Autowired
	private EventCategoryRepository eCategoryRepository;
	
	public EventCatogory create(EventCatogory eCatogory) {
		return eCategoryRepository.save(eCatogory);
	}

	public EventCatogory getById(long id) {
		return eCategoryRepository.findById(id).get();
	}

	public List<EventCatogory> listAll() {
		return eCategoryRepository.findAll();
	}

	public void delete(long id) {
		eCategoryRepository.deleteById(id);
	}

	public EventCatogory Update(EventCatogory eThemes) {
		return eCategoryRepository.save(eThemes);
	}
}
