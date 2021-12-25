package com.tourcoreservice.response.orders;

import java.util.List;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.CustomisePackageFlightinfoPojo;

public class CustomisePackageFlightinfoPojoListResponse extends AbstractPojoResponse{

	private List<CustomisePackageFlightinfoPojo> customisePackageFlightinfoPojo;

	public List<CustomisePackageFlightinfoPojo> getCustomisePackageFlightinfoPojo() {
		return customisePackageFlightinfoPojo;
	}

	public void setCustomisePackageFlightinfoPojo(List<CustomisePackageFlightinfoPojo> customisePackageFlightinfoPojo) {
		this.customisePackageFlightinfoPojo = customisePackageFlightinfoPojo;
	}
	
}
