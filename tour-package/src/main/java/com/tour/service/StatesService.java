package com.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.repository.StatesRepository;
import com.tourcoreservice.entity.States;

@Service
public class StatesService {

	@Autowired
	StatesRepository statesRepository;
	
	public States saveStates(States statesEntity) {
		return statesRepository.save(statesEntity);
	}

	public List<States> listAllStates() {
		return statesRepository.findAll();
	}

	public States getStateById(Long id) {
		return statesRepository.findById(id).get();
	}

	public States UpdateStateById(States statesEntity) {
		return statesRepository.save(statesEntity);
	}

	public void deleteStateById(long id) {
		statesRepository.deleteById(id);
	}

	public States findStateByName(String name) {
		// TODO Auto-generated method stub
		return statesRepository.findByname(name);
	}

}
