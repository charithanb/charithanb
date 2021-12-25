package com.order.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.orderservice.repository.CustomisePackageIteneryRepository;
import com.tourcoreservice.entity.CustomisePackageIternery;

@Service
public class CustomisePackageIteneryService {

	@Autowired
	private CustomisePackageIteneryRepository customisePackageItenaryRepository;

	public CustomisePackageIternery create(CustomisePackageIternery customisePackageIternery) {
		return customisePackageItenaryRepository.save(customisePackageIternery);
	}

	public List<CustomisePackageIternery> listAll() {
		return customisePackageItenaryRepository.findAll();
	}

	public CustomisePackageIternery getById(Long id) {
		return customisePackageItenaryRepository.findById(id).get();
	}

	public void deleteItenary(long id) {
		customisePackageItenaryRepository.deleteById(id);

	}

	public CustomisePackageIternery Update(CustomisePackageIternery customisePackageIternery) {
		return customisePackageItenaryRepository.save(customisePackageIternery);
	}

}
