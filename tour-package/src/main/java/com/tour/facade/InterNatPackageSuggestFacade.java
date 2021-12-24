package com.tour.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tour.service.InterNatPackageSuggestService;
import com.tour.util.ObjectMapperUtils;
import com.tourcoreservice.entity.InterNatPackageSuggest;
import com.tourcoreservice.pojo.tourpackage.InterNatPackageSuggestPojo;
import com.tourcoreservice.response.tourpackage.InterNatPackageSuggestPojoListResponse;
import com.tourcoreservice.response.tourpackage.InterNatPackageSuggestPojoResponse;

@Component
public class InterNatPackageSuggestFacade {

	@Autowired
	InterNatPackageSuggestService interNatPackageSuggestService;

	public InterNatPackageSuggestPojoResponse create(InterNatPackageSuggestPojo packageSuggestPojo) {
		InterNatPackageSuggest packageSuggest = ObjectMapperUtils.map(packageSuggestPojo, InterNatPackageSuggest.class);
		packageSuggest = interNatPackageSuggestService.create(packageSuggest);
		packageSuggestPojo = ObjectMapperUtils.map(packageSuggest, InterNatPackageSuggestPojo.class);
		InterNatPackageSuggestPojoResponse packageSuggestPojoResponse = new InterNatPackageSuggestPojoResponse();
		packageSuggestPojoResponse.setInterNatPackageSuggestPojo(packageSuggestPojo);
		return packageSuggestPojoResponse;
	}

	public InterNatPackageSuggestPojoListResponse getAll() {
		InterNatPackageSuggestPojoListResponse PackagePojoListResponse = new InterNatPackageSuggestPojoListResponse();
		List<InterNatPackageSuggest> packList = interNatPackageSuggestService.getAll();
		List<InterNatPackageSuggestPojo> PackagePojoList = ObjectMapperUtils.mapAll(packList,
				InterNatPackageSuggestPojo.class);
		PackagePojoListResponse.setInterNatPackageSuggestPojo(PackagePojoList);
		return PackagePojoListResponse;

	}

	public void delete(long id) {
		interNatPackageSuggestService.delete(id);

	}

	public InterNatPackageSuggestPojoResponse update(InterNatPackageSuggestPojo packageSuggestPojo) {
		InterNatPackageSuggest interNatPackageSuggest = ObjectMapperUtils.map(packageSuggestPojo,
				InterNatPackageSuggest.class);
		interNatPackageSuggest = interNatPackageSuggestService.Update(interNatPackageSuggest);
		packageSuggestPojo = ObjectMapperUtils.map(interNatPackageSuggest, InterNatPackageSuggestPojo.class);
		InterNatPackageSuggestPojoResponse packageSuggestPojoResponse = new InterNatPackageSuggestPojoResponse();
		return packageSuggestPojoResponse;
	}

}
