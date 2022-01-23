package com.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.repository.InterNatPackageSuggestRepository;
import com.tourcoreservice.entity.InterNatPackageSuggest;

@Service
public class InterNatPackageSuggestService {

	@Autowired
	private InterNatPackageSuggestRepository interNatPackageSuggestRepository;

	public InterNatPackageSuggest create(InterNatPackageSuggest packageSuggest) {
		return interNatPackageSuggestRepository.save(packageSuggest);
	}

	public List<InterNatPackageSuggest> getAll() {
		return interNatPackageSuggestRepository.findAll();
	}

	public void delete(long id) {
		interNatPackageSuggestRepository.deleteById(id);
	}

	public InterNatPackageSuggest Update(InterNatPackageSuggest interNatPackageSuggest) {
		return interNatPackageSuggestRepository.save(interNatPackageSuggest);
	}

	public InterNatPackageSuggest getByid(long id) {
		return interNatPackageSuggestRepository.findById(id);
	}
}
