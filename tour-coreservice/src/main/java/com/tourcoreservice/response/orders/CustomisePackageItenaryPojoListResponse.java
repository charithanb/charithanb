package com.tourcoreservice.response.orders;

import java.util.List;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.CustomisePackageIteneryPojo;

public class CustomisePackageItenaryPojoListResponse extends AbstractPojoResponse{

	private List<CustomisePackageIteneryPojo> customisePackageIteneryPojo;

	public List<CustomisePackageIteneryPojo> getCustomisePackageIteneryPojo() {
		return customisePackageIteneryPojo;
	}

	public void setCustomisePackageIteneryPojo(List<CustomisePackageIteneryPojo> customisePackageIteneryPojo) {
		this.customisePackageIteneryPojo = customisePackageIteneryPojo;
	}
	
}
