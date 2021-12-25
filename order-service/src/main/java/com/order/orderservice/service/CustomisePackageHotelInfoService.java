package com.order.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.orderservice.repository.CustomisePackageHotelInfoRepository;
import com.tourcoreservice.entity.CustomisePackageHotelInfo;

@Service
public class CustomisePackageHotelInfoService {

	@Autowired
	private CustomisePackageHotelInfoRepository customisePackageHotelInfoRepository;

	public CustomisePackageHotelInfo create(CustomisePackageHotelInfo customisePackageHotelInfo) {
		return customisePackageHotelInfoRepository.save(customisePackageHotelInfo);
	}

	public List<CustomisePackageHotelInfo> listAll() {
		return customisePackageHotelInfoRepository.findAll();
	}

	public CustomisePackageHotelInfo getById(Long id) {
		return customisePackageHotelInfoRepository.findById(id).get();
	}

	public void deleteById(long id) {
		customisePackageHotelInfoRepository.deleteById(id);

	}

	public CustomisePackageHotelInfo Update(CustomisePackageHotelInfo customisePackageHotelInfo) {
		return customisePackageHotelInfoRepository.save(customisePackageHotelInfo);
	}

}
