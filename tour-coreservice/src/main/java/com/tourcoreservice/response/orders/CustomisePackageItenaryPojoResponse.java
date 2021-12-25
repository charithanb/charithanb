package com.tourcoreservice.response.orders;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.CustomisePackageIteneryPojo;

public class CustomisePackageItenaryPojoResponse extends AbstractPojoResponse{

	private CustomisePackageIteneryPojo customisePackageIteneryPojo;

	public CustomisePackageIteneryPojo getCustomisePackageIteneryPojo() {
		return customisePackageIteneryPojo;
	}

	public void setCustomisePackageIteneryPojo(CustomisePackageIteneryPojo customisePackageIteneryPojo) {
		this.customisePackageIteneryPojo = customisePackageIteneryPojo;
	}
	
}
