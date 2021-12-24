package com.tour.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.tour.service.RegionService;
import com.tourcoreservice.entity.District;
import com.tourcoreservice.entity.Regions;
import com.tourcoreservice.entity.States;
import com.tourcoreservice.entity.Taluk;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.tourpackage.DistrictPojo;
import com.tourcoreservice.pojo.tourpackage.RegionPojo;
import com.tourcoreservice.pojo.tourpackage.TalukPojo;
import com.tourcoreservice.response.tourpackage.RegionDestrictTalukPojoResponse;
import com.tourcoreservice.response.tourpackage.RegionDistrictTalukPojoListResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class RegionFacade {

	@Autowired
	private RegionService regionService;

	public RegionDestrictTalukPojoResponse create(RegionPojo regionPojo) {
		Regions regions = ObjectMapperUtils.map(regionPojo, Regions.class);
		regions = regionService.create(regions);
		regionPojo = ObjectMapperUtils.map(regions, RegionPojo.class);
		return createDeleteUpdateResponse(regionPojo, "Created Successfully", null, null);
	}

	public RegionDistrictTalukPojoListResponse all() {
		RegionDistrictTalukPojoListResponse regionDistrictTalukPojoListResponse = new RegionDistrictTalukPojoListResponse();
		List<Regions> rengionsEntity = regionService.findAll();
		List<RegionPojo> regionPojoList = ObjectMapperUtils.mapAll(rengionsEntity, RegionPojo.class);
		regionDistrictTalukPojoListResponse.setRegionPojoPojolist(regionPojoList);
		return regionDistrictTalukPojoListResponse;
	}

	private RegionDestrictTalukPojoResponse createDeleteUpdateResponse(RegionPojo regionPojo, String message,
			DistrictPojo districtPojo, TalukPojo talukPojo) {
		RegionDestrictTalukPojoResponse regionDestrictTalukPojoResponse = new RegionDestrictTalukPojoResponse();
		List<ResponseMessagePojo> successMessaages = new ArrayList<>();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		responseMessagePojo.setSuccessMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessaages.add(responseMessagePojo);
		regionDestrictTalukPojoResponse.setRegionPojo(regionPojo);
		regionDestrictTalukPojoResponse.setDistrictPojo(districtPojo);
		regionDestrictTalukPojoResponse.setTalukPojo(talukPojo);
		regionDestrictTalukPojoResponse.setSuccessMessaages(successMessaages);
		return regionDestrictTalukPojoResponse;
	}

	public RegionDestrictTalukPojoResponse update(RegionPojo regionPojo) {
		Optional<Regions> region = regionService.findRegionById(regionPojo.getId());
		ObjectMapperUtils.map(regionPojo, region.get());
		Regions regionEntity = regionService.save(region.get());
		regionPojo = ObjectMapperUtils.map(regionEntity, RegionPojo.class);
		return createDeleteUpdateResponse(regionPojo, "Updated Successfully", null, null);
	}

	public RegionDestrictTalukPojoResponse delete(Long id) {
		regionService.delete(id);
		return createDeleteUpdateResponse(null, "Deleted Successfully", null, null);
	}

	public RegionDestrictTalukPojoResponse regionById(Long id) {
		Optional<Regions> region = regionService.findRegionById(id);
		RegionDestrictTalukPojoResponse regionDestrictTalukPojoResponse = new RegionDestrictTalukPojoResponse();
		RegionPojo regionPojo = ObjectMapperUtils.map(region.get(), RegionPojo.class);
		regionDestrictTalukPojoResponse.setRegionPojo(regionPojo);
		return regionDestrictTalukPojoResponse;
	}

	public RegionDestrictTalukPojoResponse createDistrict(DistrictPojo districtPojo) {
		District district = ObjectMapperUtils.map(districtPojo, District.class);
		district = regionService.createDistrict(district);
		districtPojo = ObjectMapperUtils.map(district, DistrictPojo.class);
		return createDeleteUpdateResponse(null, "Created Successfully", districtPojo, null);
	}

	public RegionDistrictTalukPojoListResponse allDistricts() {
		RegionDistrictTalukPojoListResponse regionDistrictTalukPojoListResponse = new RegionDistrictTalukPojoListResponse();
		List<District> districtEntity = regionService.findAllDistricts();
		List<DistrictPojo> districtPojoList = ObjectMapperUtils.mapAll(districtEntity, DistrictPojo.class);
		regionDistrictTalukPojoListResponse.setDistrictPojoList(districtPojoList);
		return regionDistrictTalukPojoListResponse;
	}

	public RegionDestrictTalukPojoResponse updateDistrict(DistrictPojo districtPojo) {
		Optional<District> district = regionService.findDistrictById(districtPojo.getId());
		if (!ObjectUtils.isEmpty(district.get().getState())) {
			deleteSatesExists(district.get(),district.get().getState());
		}
		ObjectMapperUtils.map(districtPojo, district.get());
		District districtEntity = regionService.updateDistrict(district.get());
		districtPojo = ObjectMapperUtils.map(districtEntity, DistrictPojo.class);
		return createDeleteUpdateResponse(null, "Updated Successfully", districtPojo, null);
	}

	private void deleteSatesExists(District district, States state) {
		state=null;
		district.setState(state);
		regionService.saveDistrict(district);
	}

	public RegionDestrictTalukPojoResponse deleteDistrict(Long id) {
		regionService.deleteDistrict(id);
		return createDeleteUpdateResponse(null, "Deleted Successfully", null, null);
	}

	public RegionDestrictTalukPojoResponse getDistrictById(Long id) {
		RegionDestrictTalukPojoResponse regionDestrictTalukPojoResponse = new RegionDestrictTalukPojoResponse();
		Optional<District> district = regionService.findDistrictById(id);
		DistrictPojo districtPojo = ObjectMapperUtils.map(district.get(), DistrictPojo.class);
		regionDestrictTalukPojoResponse.setDistrictPojo(districtPojo);
		return regionDestrictTalukPojoResponse;
	}

	public RegionDestrictTalukPojoResponse createTaluk(TalukPojo talukPojo) {
		Taluk taluk = ObjectMapperUtils.map(talukPojo, Taluk.class);
		taluk = regionService.createTaluk(taluk);
		talukPojo = ObjectMapperUtils.map(taluk, TalukPojo.class);
		return createDeleteUpdateResponse(null, "Created Successfully", null, talukPojo);
	}

	public RegionDistrictTalukPojoListResponse allTaluk() {
		RegionDistrictTalukPojoListResponse regionDistrictTalukPojoListResponse = new RegionDistrictTalukPojoListResponse();
		List<Taluk> talukEntity = regionService.findAllTaluk();
		List<TalukPojo> talukPojoList = ObjectMapperUtils.mapAll(talukEntity, TalukPojo.class);
		regionDistrictTalukPojoListResponse.setTalukPojoList(talukPojoList);
		return regionDistrictTalukPojoListResponse;
	}

	public RegionDestrictTalukPojoResponse updateTaluk(TalukPojo talukPojo) {
		Optional<Taluk> taluk = regionService.findTalukById(talukPojo.getId());
		if (!ObjectUtils.isEmpty(taluk.get().getDistrict())) {
			deleteExisting(taluk.get(),taluk.get().getDistrict());
		}
		ObjectMapperUtils.map(talukPojo, taluk.get());
		Taluk talukEntity = regionService.updateTaluk(taluk.get());
		talukPojo = ObjectMapperUtils.map(talukEntity, TalukPojo.class);
		return createDeleteUpdateResponse(null, "Updated Successfully", null, talukPojo);
	}

	private void deleteExisting(Taluk taluk, District district) {
		
		district=null;
		taluk.setDistrict(district);
		regionService.saveTaluk(taluk);
	}

	public RegionDestrictTalukPojoResponse deleteTaluk(Long id) {
		regionService.deleteTaluk(id);
		return createDeleteUpdateResponse(null, "Deleted Successfully", null, null);
	}

	public RegionDestrictTalukPojoResponse getTalukById(Long id) {
		RegionDestrictTalukPojoResponse regionDestrictTalukPojoResponse = new RegionDestrictTalukPojoResponse();
		Optional<Taluk> taluk = regionService.findTalukById(id);
		TalukPojo talukPojo = ObjectMapperUtils.map(taluk.get(), TalukPojo.class);
		regionDestrictTalukPojoResponse.setTalukPojo(talukPojo);
		return regionDestrictTalukPojoResponse;
	}
}
