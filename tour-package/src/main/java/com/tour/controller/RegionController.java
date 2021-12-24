package com.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tour.facade.RegionFacade;
import com.tourcoreservice.pojo.tourpackage.DistrictPojo;
import com.tourcoreservice.pojo.tourpackage.RegionPojo;
import com.tourcoreservice.pojo.tourpackage.TalukPojo;
import com.tourcoreservice.response.tourpackage.RegionDestrictTalukPojoResponse;
import com.tourcoreservice.response.tourpackage.RegionDistrictTalukPojoListResponse;

@RestController
@RequestMapping("/region")
public class RegionController {

	@Autowired
	private RegionFacade regionFacade;

	@PostMapping
	public RegionDestrictTalukPojoResponse create(@RequestBody RegionPojo regionPojo) {
		return regionFacade.create(regionPojo);

	}

	@GetMapping
	public RegionDistrictTalukPojoListResponse all() {
		return regionFacade.all();
	}
	
	@GetMapping("region/{id}")
	public RegionDestrictTalukPojoResponse getById(@PathVariable("id") Long id) {
		return regionFacade.regionById(id);
		
	}
	
	@PutMapping
	public RegionDestrictTalukPojoResponse update(@RequestBody RegionPojo regionPojo) {
		return regionFacade.update(regionPojo);
	}
	
	@DeleteMapping("/{regionid}")
	public RegionDestrictTalukPojoResponse delete(@PathVariable("regionid") Long id) {
		return regionFacade.delete(id);
		
	}
	//District apis
	@PostMapping("/district")
	public RegionDestrictTalukPojoResponse createDistrict(@RequestBody DistrictPojo districtPojo) {
		return regionFacade.createDistrict(districtPojo);

	}
	
	@GetMapping("/district/alldistricts")
	public RegionDistrictTalukPojoListResponse allDistricts() {
		return regionFacade.allDistricts();
	}
	

	@PutMapping("district/update")
	public RegionDestrictTalukPojoResponse updateDistrict(@RequestBody DistrictPojo districtPojo) {
		return regionFacade.updateDistrict(districtPojo);
	}
	@DeleteMapping("/district/{districtid}")
	public RegionDestrictTalukPojoResponse deleteDistrict(@PathVariable("districtid") Long id) {
		return regionFacade.deleteDistrict(id);
		
	}
	
	@GetMapping("district/{districtid}")
	public RegionDestrictTalukPojoResponse deleteDistrictById(@PathVariable("districtid") Long id) {
		return regionFacade.getDistrictById(id);
		
	}
	
	//Taluk apis
	@PostMapping("/taluk")
	public RegionDestrictTalukPojoResponse createTaluk(@RequestBody TalukPojo talukPojo) {
		return regionFacade.createTaluk(talukPojo);

	}
	
	@GetMapping("/taluk/alltaluk")
	public RegionDistrictTalukPojoListResponse allTaluk() {
		return regionFacade.allTaluk();
	}
	

	@PutMapping("taluk/update")
	public RegionDestrictTalukPojoResponse updateTaluk(@RequestBody TalukPojo talukPojo) {
		return regionFacade.updateTaluk(talukPojo);
	}
	@DeleteMapping("/taluk/{talukid}")
	public RegionDestrictTalukPojoResponse deleteTaluk(@PathVariable("talukid") Long id) {
		return regionFacade.deleteTaluk(id);
		
	}
	
	@GetMapping("taluk/{talukid}")
	public RegionDestrictTalukPojoResponse deleteTalukById(@PathVariable("talukid") Long id) {
		return regionFacade.getTalukById(id);
		
	}


}
