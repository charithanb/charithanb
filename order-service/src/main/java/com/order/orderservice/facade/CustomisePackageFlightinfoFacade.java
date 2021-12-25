package com.order.orderservice.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.order.orderservice.service.CustomisePackageFlightinfoService;
import com.tourcoreservice.entity.CustomisePackageFlightinfo;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.orders.CustomisePackageFlightinfoPojo;
import com.tourcoreservice.response.orders.CustomisePackageFlightinfoPojoListResponse;
import com.tourcoreservice.response.orders.CustomisePackageFlightinfoPojoResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class CustomisePackageFlightinfoFacade {

	@Autowired
	private CustomisePackageFlightinfoService customisePackageFlightinfoService;

	public CustomisePackageFlightinfoPojoResponse create(
			CustomisePackageFlightinfoPojo customisePackageFlightinfoPojo) {
		CustomisePackageFlightinfo customisePackageFlightinfo = ObjectMapperUtils.map(customisePackageFlightinfoPojo,
				CustomisePackageFlightinfo.class);
		customisePackageFlightinfo = customisePackageFlightinfoService.create(customisePackageFlightinfo);
		customisePackageFlightinfoPojo = ObjectMapperUtils.map(customisePackageFlightinfo,
				CustomisePackageFlightinfoPojo.class);
		return createDeleteUpdateResponse(customisePackageFlightinfoPojo, "Customised package created Successfully ");
	}

	private CustomisePackageFlightinfoPojoResponse createDeleteUpdateResponse(
			CustomisePackageFlightinfoPojo customisePackageFlightinfoPojo, String message) {

		CustomisePackageFlightinfoPojoResponse customisedPackageFlightinfoPojoResponse = new CustomisePackageFlightinfoPojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessages = new ArrayList<>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessages.add(responseMessagePojo);
		customisedPackageFlightinfoPojoResponse.setCustomisePackageFlightinfoPojo(customisePackageFlightinfoPojo);
		customisedPackageFlightinfoPojoResponse.setSuccessMessaages(successMessages);
		return customisedPackageFlightinfoPojoResponse;
	}

	public CustomisePackageFlightinfoPojoListResponse listAll() {
		CustomisePackageFlightinfoPojoListResponse customisePackageFlightinfoPojoListResponse = new CustomisePackageFlightinfoPojoListResponse();
		List<CustomisePackageFlightinfo> customisePackageFlightinfo = customisePackageFlightinfoService.listAll();
		List<CustomisePackageFlightinfoPojo> customisePackageFlightinfoPojo = ObjectMapperUtils
				.mapAll(customisePackageFlightinfo, CustomisePackageFlightinfoPojo.class);
		customisePackageFlightinfoPojoListResponse.setCustomisePackageFlightinfoPojo(customisePackageFlightinfoPojo);
		return customisePackageFlightinfoPojoListResponse;
	}

	public CustomisePackageFlightinfoPojoResponse getDataByid(Long id) {
		CustomisePackageFlightinfoPojoResponse customisePackageFlightinfoPojoResponse = new CustomisePackageFlightinfoPojoResponse();
		CustomisePackageFlightinfo customisePackageFlightinfo = customisePackageFlightinfoService.getById(id);
		CustomisePackageFlightinfoPojo customisePackageFlightinfoPojo = ObjectMapperUtils
				.map(customisePackageFlightinfo, CustomisePackageFlightinfoPojo.class);
		customisePackageFlightinfoPojoResponse.setCustomisePackageFlightinfoPojo(customisePackageFlightinfoPojo);
		return customisePackageFlightinfoPojoResponse;
	}

	public CustomisePackageFlightinfoPojoResponse delete(long id) {
		customisePackageFlightinfoService.deleteCustomisePackageFlightinfo(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");

	}

	public CustomisePackageFlightinfoPojoResponse update(
			CustomisePackageFlightinfoPojo customisePackageFlightinfoPojo) {
		CustomisePackageFlightinfo customisePackageFlightinfo = customisePackageFlightinfoService
				.getById(customisePackageFlightinfoPojo.getId());
		ObjectMapperUtils.map(customisePackageFlightinfoPojo, customisePackageFlightinfo);
		customisePackageFlightinfo = customisePackageFlightinfoService.Update(customisePackageFlightinfo);
		customisePackageFlightinfoPojo = ObjectMapperUtils.map(customisePackageFlightinfo,
				CustomisePackageFlightinfoPojo.class);
		return createDeleteUpdateResponse(customisePackageFlightinfoPojo, "Updated successfully");
	}

}
