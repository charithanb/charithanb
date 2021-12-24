package com.events.westernevents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.events.westernevents.repository.MainEventPubsRepository;
import com.tourcoreservice.entity.events.MainEventPubs;

@Service
public class MainEventPubsService {

	@Autowired
	private MainEventPubsRepository mEventPubsRepository;
	
	public MainEventPubs create(MainEventPubs mEventPubs) {
		return mEventPubsRepository.save(mEventPubs);
	}

	public MainEventPubs getById(long id) {
		return mEventPubsRepository.findById(id).get();
	}

	public List<MainEventPubs> listAll() {
		return mEventPubsRepository.findAll();
	}

	public void delete(long id) {
		mEventPubsRepository.deleteById(id);

	}

	public MainEventPubs Update(MainEventPubs mEventPubs) {
		return mEventPubsRepository.save(mEventPubs);
	}

}
