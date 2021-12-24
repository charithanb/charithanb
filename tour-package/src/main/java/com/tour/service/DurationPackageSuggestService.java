package com.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.repository.DurationPackageSuggestRepository;
import com.tourcoreservice.entity.DurationPackageSuggest;

@Service
public class DurationPackageSuggestService {

	@Autowired
	private DurationPackageSuggestRepository durationRepository;

	public DurationPackageSuggest create(DurationPackageSuggest duration) {
		return durationRepository.save(duration);
	}

	public DurationPackageSuggest getById(long id) {
		return durationRepository.findById(id).get();
	}

	public List<DurationPackageSuggest> listAll() {
		return durationRepository.findAll();
	}

	public void delete(long id) {
		durationRepository.deleteById(id);

	}

	public DurationPackageSuggest Update(DurationPackageSuggest duration) {
		return durationRepository.save(duration);
	}

	public void save(DurationPackageSuggest duration) {
		durationRepository.save(duration);

	}

}
