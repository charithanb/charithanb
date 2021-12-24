package com.tour.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tour.service.IndianPackageSuggestService;
import com.tour.util.ObjectMapperUtils;
import com.tourcoreservice.entity.IndianPackageSuggest;
import com.tourcoreservice.pojo.tourpackage.IndianPackageSuggestPojo;
import com.tourcoreservice.response.tourpackage.IndianPackageSuggestPojoListResponse;
import com.tourcoreservice.response.tourpackage.IndianPackageSuggestPojoResponse;

@Component
public class IndianPackageSuggestFacade {
	
	@Autowired 
	IndianPackageSuggestService indianPackageSuggestService;

	public IndianPackageSuggestPojoResponse create(IndianPackageSuggestPojo packageSuggestPojo) {
		IndianPackageSuggest packageSuggest = ObjectMapperUtils.map(packageSuggestPojo, IndianPackageSuggest.class);
		packageSuggest = indianPackageSuggestService.create(packageSuggest);
		packageSuggestPojo = ObjectMapperUtils.map(packageSuggest, IndianPackageSuggestPojo.class);
		IndianPackageSuggestPojoResponse packageSuggestPojoResponse = new IndianPackageSuggestPojoResponse();
		packageSuggestPojoResponse.setIndianPackageSuggestPojo(packageSuggestPojo);
		return packageSuggestPojoResponse;
	}

	public IndianPackageSuggestPojoListResponse getAll() {
		IndianPackageSuggestPojoListResponse packageSuggestPojoResponse = new IndianPackageSuggestPojoListResponse();
		List<IndianPackageSuggest> packList = indianPackageSuggestService.getAll();
		List<IndianPackageSuggestPojo> PackagePojoList = ObjectMapperUtils.mapAll(packList,
				IndianPackageSuggestPojo.class);
		packageSuggestPojoResponse.setIndianPackageSuggestPojos(PackagePojoList);
		return packageSuggestPojoResponse;
	}
	
	public void delete(long id) {
		indianPackageSuggestService.delete(id);

	}

	public IndianPackageSuggestPojoResponse update(IndianPackageSuggestPojo packageSuggestPojo) {
		IndianPackageSuggest indianPackageSuggest = ObjectMapperUtils.map(packageSuggestPojo,
				IndianPackageSuggest.class);
		indianPackageSuggest = indianPackageSuggestService.Update(indianPackageSuggest);
		packageSuggestPojo = ObjectMapperUtils.map(indianPackageSuggest, IndianPackageSuggestPojo.class);
		IndianPackageSuggestPojoResponse packageSuggestPojoResponse = new IndianPackageSuggestPojoResponse();
		return packageSuggestPojoResponse;
	}

}
