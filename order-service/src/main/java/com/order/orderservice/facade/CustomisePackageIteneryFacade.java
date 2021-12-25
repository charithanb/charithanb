package com.order.orderservice.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.order.orderservice.service.CustomisePackageIteneryService;
import com.tourcoreservice.entity.CustomisePackageIternery;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.orders.CustomisePackageIteneryPojo;
import com.tourcoreservice.response.orders.CustomisePackageItenaryPojoListResponse;
import com.tourcoreservice.response.orders.CustomisePackageItenaryPojoResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class CustomisePackageIteneryFacade {

	@Autowired
	private CustomisePackageIteneryService customisePackageItenaryService;

	public CustomisePackageItenaryPojoResponse createItenery(CustomisePackageIteneryPojo customisePackageItenaryPojo) {
		CustomisePackageIternery customisePackageIternery = ObjectMapperUtils.map(customisePackageItenaryPojo,
				CustomisePackageIternery.class);
		customisePackageIternery = customisePackageItenaryService.create(customisePackageIternery);
		customisePackageItenaryPojo = ObjectMapperUtils.map(customisePackageIternery,
				CustomisePackageIteneryPojo.class);
		return createDeleteUpdateResponse(customisePackageItenaryPojo,
				"Customise package itenary created Successfully ");
	}

	private CustomisePackageItenaryPojoResponse createDeleteUpdateResponse(
			CustomisePackageIteneryPojo customisePackageItenaryPojo, String message) {
		CustomisePackageItenaryPojoResponse customisePackageItenaryPojoResponse = new CustomisePackageItenaryPojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessages = new ArrayList<>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessages.add(responseMessagePojo);
		customisePackageItenaryPojoResponse.setCustomisePackageIteneryPojo(customisePackageItenaryPojo);
		customisePackageItenaryPojoResponse.setSuccessMessaages(successMessages);
		return customisePackageItenaryPojoResponse;
	}

	public CustomisePackageItenaryPojoListResponse listAll() {
		CustomisePackageItenaryPojoListResponse customisePackageItenaryPojoListResponse = new CustomisePackageItenaryPojoListResponse();
		List<CustomisePackageIternery> customisePackageItenary = customisePackageItenaryService.listAll();
		List<CustomisePackageIteneryPojo> customisePackageItenaryPojo = ObjectMapperUtils
				.mapAll(customisePackageItenary, CustomisePackageIteneryPojo.class);
		customisePackageItenaryPojoListResponse.setCustomisePackageIteneryPojo(customisePackageItenaryPojo);
		return customisePackageItenaryPojoListResponse;

	}

	public CustomisePackageItenaryPojoResponse getByid(Long id) {
		CustomisePackageItenaryPojoResponse customisePackageItenaryPojoResponse = new CustomisePackageItenaryPojoResponse();
		CustomisePackageIternery customisePackageItenary = customisePackageItenaryService.getById(id);
		CustomisePackageIteneryPojo customisePackageItenaryPojo = ObjectMapperUtils.map(customisePackageItenary,
				CustomisePackageIteneryPojo.class);
		customisePackageItenaryPojoResponse.setCustomisePackageIteneryPojo(customisePackageItenaryPojo);
		return customisePackageItenaryPojoResponse;
	}

	public CustomisePackageItenaryPojoResponse delete(long id) {
		customisePackageItenaryService.deleteItenary(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");

	}

	public CustomisePackageItenaryPojoResponse update(CustomisePackageIteneryPojo customisePackageItenaryPojo) {
		CustomisePackageIternery customisePackageIternery = customisePackageItenaryService
				.getById(customisePackageItenaryPojo.getId());
		ObjectMapperUtils.map(customisePackageItenaryPojo, customisePackageIternery);
		customisePackageIternery = customisePackageItenaryService.Update(customisePackageIternery);
		customisePackageItenaryPojo = ObjectMapperUtils.map(customisePackageIternery,
				CustomisePackageIteneryPojo.class);
		return createDeleteUpdateResponse(customisePackageItenaryPojo, "Updated successfully");
	}

}
