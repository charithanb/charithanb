package com.events.westernevents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.events.westernevents.repository.MainEventDjsRepository;
import com.tourcoreservice.entity.events.MainEventDjs;

@Service
public class MainEventDjsService {

	@Autowired
	private MainEventDjsRepository mDjsRepository;
	
	public MainEventDjs create(MainEventDjs mEventDjs) {
		return mDjsRepository.save(mEventDjs);
	}

	public MainEventDjs getById(long id) {
		return mDjsRepository.findById(id).get();
	}

	public List<MainEventDjs> listAll() {
		return mDjsRepository.findAll();
	}

	public void delete(long id) {
		mDjsRepository.deleteById(id);

	}

	public MainEventDjs Update(MainEventDjs mEventDjs) {
		return mDjsRepository.save(mEventDjs);
	}

}
