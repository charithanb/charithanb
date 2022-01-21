package com.tour.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.tour.service.IndianPackageSuggestService;
import com.tour.util.ObjectMapperUtils;
import com.tourcoreservice.entity.IndianPackageSuggest;
import com.tourcoreservice.exception.tourpackage.DataAlreadyExistException;
import com.tourcoreservice.exception.tourpackage.DataDoesNotExistException;
import com.tourcoreservice.pojo.tourpackage.IndianPackageSuggestPojo;
import com.tourcoreservice.response.tourpackage.IndianPackageSuggestPojoListResponse;
import com.tourcoreservice.response.tourpackage.IndianPackageSuggestPojoResponse;

@Component
public class IndianPackageSuggestFacade {

	@Autowired
	IndianPackageSuggestService indianPackageSuggestService;

	public IndianPackageSuggestPojoResponse create(IndianPackageSuggestPojo packageSuggestPojo) {
		ifDataAlreadyExist(packageSuggestPojo.getId());
		IndianPackageSuggest packageSuggest = ObjectMapperUtils.map(packageSuggestPojo, IndianPackageSuggest.class);
		packageSuggest = indianPackageSuggestService.create(packageSuggest);
		packageSuggestPojo = ObjectMapperUtils.map(packageSuggest, IndianPackageSuggestPojo.class);
		IndianPackageSuggestPojoResponse packageSuggestPojoResponse = new IndianPackageSuggestPojoResponse();
		packageSuggestPojoResponse.setIndianPackageSuggestPojo(packageSuggestPojo);
		return packageSuggestPojoResponse;
	}

	private void ifDataAlreadyExist(long id) {
		IndianPackageSuggest indianPackageSuggest = indianPackageSuggestService.getById(id);
		if (!ObjectUtils.isEmpty(indianPackageSuggest)) {
			throw new DataAlreadyExistException("Data already exists");
		}
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
		ifDataDoesNotExist(id);
		indianPackageSuggestService.delete(id);

	}

	public IndianPackageSuggestPojoResponse update(IndianPackageSuggestPojo packageSuggestPojo) {
		ifDataDoesNotExist(packageSuggestPojo.getId());
		IndianPackageSuggest indianPackageSuggest = ObjectMapperUtils.map(packageSuggestPojo,
				IndianPackageSuggest.class);
		indianPackageSuggest = indianPackageSuggestService.Update(indianPackageSuggest);
		packageSuggestPojo = ObjectMapperUtils.map(indianPackageSuggest, IndianPackageSuggestPojo.class);
		IndianPackageSuggestPojoResponse packageSuggestPojoResponse = new IndianPackageSuggestPojoResponse();
		return packageSuggestPojoResponse;
	}

	public IndianPackageSuggestPojoResponse getById(long id) {
		ifDataDoesNotExist(id);
		IndianPackageSuggestPojoResponse indianPackageSuggestPojoResponse = new IndianPackageSuggestPojoResponse();
		IndianPackageSuggest indianPackageSuggest = indianPackageSuggestService.getById(id);
		IndianPackageSuggestPojo indianPackageSuggestPojo = ObjectMapperUtils.map(indianPackageSuggest,
				IndianPackageSuggestPojo.class);
		indianPackageSuggestPojoResponse.setIndianPackageSuggestPojo(indianPackageSuggestPojo);
		return indianPackageSuggestPojoResponse;
	}

	private void ifDataDoesNotExist(long id) {
		IndianPackageSuggest indianPackageSuggest = new IndianPackageSuggest();
		if (ObjectUtils.isEmpty(indianPackageSuggest)) {
			throw new DataDoesNotExistException("Data doesn't exist");
		}

	}

}
