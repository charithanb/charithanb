package com.tourcoreservice.response.orders;

import java.util.List;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.CustomisePackagePojo;

public class CustomisePackagePojoListResponse extends AbstractPojoResponse{

	private List<CustomisePackagePojo> customisePackagePojo;

	public List<CustomisePackagePojo> getCustomisePackagePojo() {
		return customisePackagePojo;
	}

	public void setCustomisePackagePojo(List<CustomisePackagePojo> customisePackagePojo) {
		this.customisePackagePojo = customisePackagePojo;
	}
	
}
