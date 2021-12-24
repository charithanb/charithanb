package com.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.repository.Main_placeRepository;
import com.tourcoreservice.entity.Main_Place;

@Service
public class Main_placeService {
	@Autowired
	private Main_placeRepository main_placeRepositoty;

	public List<Main_Place> listAllMainPlace() {
		return main_placeRepositoty.findAll();
	}

	public Main_Place getMain_placeById(long id) {
		return main_placeRepositoty.findById(id).get();
    }

	public Main_Place saveMain_place(Main_Place main_PlaceEntity) {
		return main_placeRepositoty.save(main_PlaceEntity);
	}

	public Main_Place updateMain_place(Main_Place main_PlaceEntity) {
		return main_placeRepositoty.save(main_PlaceEntity);
	}

	public void deleteMain_Place(long id) {
		main_placeRepositoty.deleteById(id);
    }
}
