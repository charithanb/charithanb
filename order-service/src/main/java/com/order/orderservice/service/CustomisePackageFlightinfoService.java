package com.order.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.orderservice.repository.CustomisePackageFlightinfoRepository;
import com.tourcoreservice.entity.CustomisePackageFlightinfo;

@Service
public class CustomisePackageFlightinfoService {

	@Autowired
	private CustomisePackageFlightinfoRepository customisePackageFlightinfoRepository;

	public CustomisePackageFlightinfo create(CustomisePackageFlightinfo customisePackageFlightinfo) {
		return customisePackageFlightinfoRepository.save(customisePackageFlightinfo);
	}

	public List<CustomisePackageFlightinfo> listAll() {
		return customisePackageFlightinfoRepository.findAll();
	}

	public CustomisePackageFlightinfo getById(Long id) {
		return customisePackageFlightinfoRepository.findById(id).get();
	}

	public void deleteCustomisePackageFlightinfo(long id) {
		customisePackageFlightinfoRepository.deleteById(id);

	}

	public CustomisePackageFlightinfo Update(CustomisePackageFlightinfo customisePackageFlightinfo) {
		return customisePackageFlightinfoRepository.save(customisePackageFlightinfo);
	}

}
