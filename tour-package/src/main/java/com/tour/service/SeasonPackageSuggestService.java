package com.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.repository.SeasonPackageSuggestRepository;
import com.tourcoreservice.entity.SeasonPackageSuggest;

@Service
public class SeasonPackageSuggestService {
	@Autowired
	private SeasonPackageSuggestRepository seasonRepository;

	public SeasonPackageSuggest create(SeasonPackageSuggest season) {
		return seasonRepository.save(season);
	}

	public SeasonPackageSuggest getById(long id) {
		return seasonRepository.findById(id).get();
	}

	public List<SeasonPackageSuggest> listAll() {
		 return seasonRepository.findAll();
	}

	public void delete(SeasonPackageSuggest season) {
		seasonRepository.delete(season);
		
	}

	public SeasonPackageSuggest Update(SeasonPackageSuggest season) {
		return seasonRepository.save(season);
	}

}
