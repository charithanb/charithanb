package com.tourcoreservice.response.orders;

import java.util.List;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.CustomisePackageHotelInfoPojo;

public class CustomisePackageHotelInfoPojoListResponse extends AbstractPojoResponse{

	private List<CustomisePackageHotelInfoPojo> customisePackageHotelInfoPojo;

	public List<CustomisePackageHotelInfoPojo> getCustomisePackageHotelInfoPojo() {
		return customisePackageHotelInfoPojo;
	}

	public void setCustomisePackageHotelInfoPojo(List<CustomisePackageHotelInfoPojo> customisePackageHotelInfoPojo) {
		this.customisePackageHotelInfoPojo = customisePackageHotelInfoPojo;
	}
	
}
