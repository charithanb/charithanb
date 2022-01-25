package com.tour.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.repository.DistrictRepository;
import com.tour.repository.RegionRepository;
import com.tour.repository.TalukRepository;
import com.tourcoreservice.entity.District;
import com.tourcoreservice.entity.Regions;
import com.tourcoreservice.entity.Taluk;

@Service
public class RegionService {

	@Autowired
	private RegionRepository regionRepository;

	@Autowired
	private DistrictRepository districtRepository;

	@Autowired
	private TalukRepository talukRepository;

	public Regions create(Regions regions) {

		return regionRepository.save(regions);
	}

	public List<Regions> findAll() {

		return regionRepository.findAll();
	}

	public Regions findRegionById(long id) {
		// TODO Auto-generated method stub
		return regionRepository.findById(id);
	}

	public Regions save(Regions regions) {
		// TODO Auto-generated method stub
		return regionRepository.save(regions);
	}

	public void delete(Long id) {
		regionRepository.deleteById(id);

	}

	public District createDistrict(District district) {

		return districtRepository.save(district);
	}

	public List<District> findAllDistricts() {
		// TODO Auto-generated method stub
		return districtRepository.findAll();
	}

	public Optional<District> findDistrictById(long id) {
		// TODO Auto-generated method stub
		return districtRepository.findById(id);
	}

	public District updateDistrict(District district) {
		// TODO Auto-generated method stub
		return districtRepository.save(district);
	}

	public void deleteDistrict(Long id) {
		districtRepository.deleteById(id);

	}

	public Taluk createTaluk(Taluk taluk) {

		return talukRepository.save(taluk);
	}

	public List<Taluk> findAllTaluk() {
		// TODO Auto-generated method stub
		return talukRepository.findAll();
	}

	public Optional<Taluk> findTalukById(long id) {
		// TODO Auto-generated method stub
		return talukRepository.findTalukById(id);
	}

	public Taluk updateTaluk(Taluk taluk) {
		// TODO Auto-generated method stub
		return talukRepository.save(taluk);
	}

	public void deleteTaluk(Long id) {
		talukRepository.deleteById(id);

	}

	public void saveDistrict(District district) {
		districtRepository.save(district);

	}

	public void saveTaluk(Taluk taluk) {
		talukRepository.save(taluk);

	}

	public Regions findRegionByname(String name) {
		return regionRepository.findByName(name);
	}

	public Optional<District> findByName(String name) {
		return districtRepository.findByName(name);
	}


}
