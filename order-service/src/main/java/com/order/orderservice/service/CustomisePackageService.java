package com.order.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.orderservice.repository.CustomisePackageRepository;
import com.tourcoreservice.entity.CustomisePackage;

@Service
public class CustomisePackageService {

	@Autowired
	private CustomisePackageRepository customisePackageRepository;

	public CustomisePackage create(CustomisePackage customisePackage) {
		return customisePackageRepository.save(customisePackage);
	}

	public List<CustomisePackage> listAll() {
		return customisePackageRepository.findAll();
	}

	public CustomisePackage getDataId(Long id) {
		return customisePackageRepository.findById(id).get();
	}

	public void deletePacakge(long id) {
		customisePackageRepository.deleteById(id);

	}

	public CustomisePackage Update(CustomisePackage customisePackage) {

		return customisePackageRepository.save(customisePackage);
	}

}