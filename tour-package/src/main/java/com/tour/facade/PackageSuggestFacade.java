package com.tour.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.tour.service.PackageSuggestService;
import com.tour.util.ObjectMapperUtils;
import com.tourcoreservice.entity.PackageSuggest;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.tourpackage.PackageSuggestPojo;
import com.tourcoreservice.response.tourpackage.PackageSuggestPojoListResponse;
import com.tourcoreservice.response.tourpackage.PackageSuggestPojoResponse;

@Component
public class PackageSuggestFacade {
	@Autowired
	PackageSuggestService packageSuggestService;

	public PackageSuggestPojoResponse create(PackageSuggestPojo packageSuggestPojo) {
		PackageSuggest packageSuggest = ObjectMapperUtils.map(packageSuggestPojo, PackageSuggest.class);
		packageSuggest = packageSuggestService.create(packageSuggest);
		packageSuggestPojo = ObjectMapperUtils.map(packageSuggest, PackageSuggestPojo.class);
		return createDeleteUpdateResponse(packageSuggestPojo, "Created successfully");
	}

	private PackageSuggestPojoResponse createDeleteUpdateResponse(PackageSuggestPojo packageSuggestPojo,
			String message) {
		PackageSuggestPojoResponse packageSuggestPojoResponse = new PackageSuggestPojoResponse();
		List<ResponseMessagePojo> successMessaages = new ArrayList<>();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		responseMessagePojo.setSuccessMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessaages.add(responseMessagePojo);
		packageSuggestPojoResponse.setPackageSuggestPojo(packageSuggestPojo);
		packageSuggestPojoResponse.setSuccessMessaages(successMessaages);
		return packageSuggestPojoResponse;
	}

	public PackageSuggestPojoResponse get(long id) {
		PackageSuggestPojoResponse packageSuggestPojoResponse = new PackageSuggestPojoResponse();
		PackageSuggest packageSuggest = packageSuggestService.getById(id);
		PackageSuggestPojo packageSuggestPojo = ObjectMapperUtils.map(packageSuggest, PackageSuggestPojo.class);
		packageSuggestPojoResponse.setPackageSuggestPojo(packageSuggestPojo);
		return packageSuggestPojoResponse;
	}

	public PackageSuggestPojoListResponse listAll() {
		PackageSuggestPojoListResponse packageSuggestPojoListResponse = new PackageSuggestPojoListResponse();
		List<PackageSuggest> PackageSuggest = packageSuggestService.listAll();
		List<PackageSuggestPojo> packageSuggestPojo = ObjectMapperUtils.mapAll(PackageSuggest,
				PackageSuggestPojo.class);
		packageSuggestPojoListResponse.setPackageSuggestPojo(packageSuggestPojo);
		return packageSuggestPojoListResponse;
	}

	public PackageSuggestPojoResponse delete(long id) {
		packageSuggestService.delete(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");

	}

	public PackageSuggestPojoResponse update(PackageSuggestPojo packageSuggestPojo) {
		PackageSuggest packageSuggest = ObjectMapperUtils.map(packageSuggestPojo, PackageSuggest.class);
		packageSuggest = packageSuggestService.Update(packageSuggest);
		packageSuggestPojo = ObjectMapperUtils.map(packageSuggest, PackageSuggestPojo.class);
		return createDeleteUpdateResponse(packageSuggestPojo, "Updated successfully");
	}

}
