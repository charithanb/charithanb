package com.tourcoreservice.response.orders;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.CustomisePackageFlightinfoPojo;

public class CustomisePackageFlightinfoPojoResponse extends AbstractPojoResponse{

	private CustomisePackageFlightinfoPojo customisePackageFlightinfoPojo;

	public CustomisePackageFlightinfoPojo getCustomisePackageFlightinfoPojo() {
		return customisePackageFlightinfoPojo;
	}

	public void setCustomisePackageFlightinfoPojo(CustomisePackageFlightinfoPojo customisePackageFlightinfoPojo) {
		this.customisePackageFlightinfoPojo = customisePackageFlightinfoPojo;
	}
	
	
}
