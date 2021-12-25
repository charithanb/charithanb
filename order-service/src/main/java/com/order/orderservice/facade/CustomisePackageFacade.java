package com.order.orderservice.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.order.orderservice.service.CustomisePackageService;
import com.tourcoreservice.entity.CustomisePackage;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.orders.CustomisePackagePojo;
import com.tourcoreservice.response.orders.CustomisePackagePojoListResponse;
import com.tourcoreservice.response.orders.CustomisePackagePojoRespone;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class CustomisePackageFacade {

	@Autowired
	private CustomisePackageService customisePackageService;

	public CustomisePackagePojoRespone create(CustomisePackagePojo customisePackagePojo) {
		CustomisePackage customisePackage = ObjectMapperUtils.map(customisePackagePojo, CustomisePackage.class);
		customisePackage = customisePackageService.create(customisePackage);
		customisePackagePojo = ObjectMapperUtils.map(customisePackage, CustomisePackagePojo.class);
		return createDeleteUpdateResponse(customisePackagePojo, "CustomisePackage created Successfully ");
	}

	public CustomisePackagePojoListResponse listAll() {
		CustomisePackagePojoListResponse customisePackagePojoListResponse = new CustomisePackagePojoListResponse();
		List<CustomisePackage> customisePackage = customisePackageService.listAll();
		List<CustomisePackagePojo> customisePackagePojo = ObjectMapperUtils.mapAll(customisePackage,
				CustomisePackagePojo.class);
		customisePackagePojoListResponse.setCustomisePackagePojo(customisePackagePojo);
		return customisePackagePojoListResponse;
	}

	public CustomisePackagePojoRespone getData(Long id) {
		CustomisePackagePojoRespone customisePackagePojoRespone = new CustomisePackagePojoRespone();
		CustomisePackage customisePackage = customisePackageService.getDataId(id);
		CustomisePackagePojo customisePackagePojo = ObjectMapperUtils.map(customisePackage, CustomisePackagePojo.class);
		customisePackagePojoRespone.setCustomisePackagePojo(customisePackagePojo);
		return customisePackagePojoRespone;
	}

	public CustomisePackagePojoRespone delete(long id) {
		customisePackageService.deletePacakge(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");

	}

	public CustomisePackagePojoRespone update(CustomisePackagePojo customisePackagePojo) {
		CustomisePackage customisePackage = customisePackageService.getDataId(customisePackagePojo.getId());
		ObjectMapperUtils.map(customisePackagePojo, customisePackage);
		customisePackage = customisePackageService.Update(customisePackage);
		customisePackagePojo = ObjectMapperUtils.map(customisePackage, CustomisePackagePojo.class);
		return createDeleteUpdateResponse(customisePackagePojo, "Updated successfully");
	}

	private CustomisePackagePojoRespone createDeleteUpdateResponse(CustomisePackagePojo customisePackagePojo,
			String message) {
		CustomisePackagePojoRespone customisePackagePojoRespone = new CustomisePackagePojoRespone();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessages = new ArrayList<>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessages.add(responseMessagePojo);
		customisePackagePojoRespone.setCustomisePackagePojo(customisePackagePojo);
		customisePackagePojoRespone.setSuccessMessaages(successMessages);
		return customisePackagePojoRespone;
	}
}