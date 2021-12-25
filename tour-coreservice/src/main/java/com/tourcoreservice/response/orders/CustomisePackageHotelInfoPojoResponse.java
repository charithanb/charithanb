package com.tourcoreservice.response.orders;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.CustomisePackageHotelInfoPojo;

public class CustomisePackageHotelInfoPojoResponse extends AbstractPojoResponse {

	private CustomisePackageHotelInfoPojo customisePackageHotelInfoPojo;

	public CustomisePackageHotelInfoPojo getCustomisePackageHotelInfoPojo() {
		return customisePackageHotelInfoPojo;
	}

	public void setCustomisePackageHotelInfoPojo(CustomisePackageHotelInfoPojo customisePackageHotelInfoPojo) {
		this.customisePackageHotelInfoPojo = customisePackageHotelInfoPojo;
	}
	
}
