package com.order.orderservice.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.order.orderservice.service.CustomisePackageHotelInfoService;
import com.tourcoreservice.entity.CustomisePackageHotelInfo;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.orders.CustomisePackageHotelInfoPojo;
import com.tourcoreservice.response.orders.CustomisePackageHotelInfoPojoListResponse;
import com.tourcoreservice.response.orders.CustomisePackageHotelInfoPojoResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class CustomisePackageHotelInfoFacade {

	@Autowired
	private CustomisePackageHotelInfoService customisePackageHotelInfoService;

	public CustomisePackageHotelInfoPojoResponse create(CustomisePackageHotelInfoPojo customisePackageHotelInfoPojo) {
		CustomisePackageHotelInfo customisePackageHotelInfo = ObjectMapperUtils.map(customisePackageHotelInfoPojo,
				CustomisePackageHotelInfo.class);
		customisePackageHotelInfo = customisePackageHotelInfoService.create(customisePackageHotelInfo);
		customisePackageHotelInfoPojo = ObjectMapperUtils.map(customisePackageHotelInfo,
				CustomisePackageHotelInfoPojo.class);
		return createDeleteUpdateResponse(customisePackageHotelInfoPojo, "Order created Successfully ");
	}

	private CustomisePackageHotelInfoPojoResponse createDeleteUpdateResponse(
			CustomisePackageHotelInfoPojo customisePackageHotelInfoPojo, String message) {
		CustomisePackageHotelInfoPojoResponse customisePackageHotelInfoPojoResponse = new CustomisePackageHotelInfoPojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessages = new ArrayList<>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessages.add(responseMessagePojo);
		customisePackageHotelInfoPojoResponse.setCustomisePackageHotelInfoPojo(customisePackageHotelInfoPojo);
		customisePackageHotelInfoPojoResponse.setSuccessMessaages(successMessages);
		return customisePackageHotelInfoPojoResponse;
	}

	public CustomisePackageHotelInfoPojoListResponse listAll() {
		CustomisePackageHotelInfoPojoListResponse CustomisePackageHotelInfoPojoListResponse = new CustomisePackageHotelInfoPojoListResponse();
		List<CustomisePackageHotelInfo> customisePackageHotelInfo = customisePackageHotelInfoService.listAll();
		List<CustomisePackageHotelInfoPojo> customisePackageHotelInfoPojo = ObjectMapperUtils
				.mapAll(customisePackageHotelInfo, CustomisePackageHotelInfoPojo.class);
		CustomisePackageHotelInfoPojoListResponse.setCustomisePackageHotelInfoPojo(customisePackageHotelInfoPojo);
		return CustomisePackageHotelInfoPojoListResponse;
	}

	public CustomisePackageHotelInfoPojoResponse getByid(Long id) {
		CustomisePackageHotelInfoPojoResponse customisePackageHotelInfoPojoResponse = new CustomisePackageHotelInfoPojoResponse();
		CustomisePackageHotelInfo customisePackageHotelInfo = customisePackageHotelInfoService.getById(id);
		CustomisePackageHotelInfoPojo customisePackageHotelInfoPojo = ObjectMapperUtils.map(customisePackageHotelInfo,
				CustomisePackageHotelInfoPojo.class);
		customisePackageHotelInfoPojoResponse.setCustomisePackageHotelInfoPojo(customisePackageHotelInfoPojo);
		return customisePackageHotelInfoPojoResponse;
	}

	public CustomisePackageHotelInfoPojoResponse delete(long id) {
		customisePackageHotelInfoService.deleteById(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");

	}

	public CustomisePackageHotelInfoPojoResponse update(CustomisePackageHotelInfoPojo customisePackageHotelInfoPojo) {
		CustomisePackageHotelInfo customisePackageHotelInfo = customisePackageHotelInfoService
				.getById(customisePackageHotelInfoPojo.getId());
		ObjectMapperUtils.map(customisePackageHotelInfoPojo, customisePackageHotelInfo);
		customisePackageHotelInfo = customisePackageHotelInfoService.Update(customisePackageHotelInfo);
		customisePackageHotelInfoPojo = ObjectMapperUtils.map(customisePackageHotelInfo,
				CustomisePackageHotelInfoPojo.class);
		return createDeleteUpdateResponse(customisePackageHotelInfoPojo, "Updated successfully");
	}

}
