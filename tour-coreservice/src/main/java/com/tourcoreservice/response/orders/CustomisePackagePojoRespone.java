package com.tourcoreservice.response.orders;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.CustomisePackagePojo;

public class CustomisePackagePojoRespone extends AbstractPojoResponse{

	private CustomisePackagePojo customisePackagePojo;

	public CustomisePackagePojo getCustomisePackagePojo() {
		return customisePackagePojo;
	}

	public void setCustomisePackagePojo(CustomisePackagePojo customisePackagePojo) {
		this.customisePackagePojo = customisePackagePojo;
	}
	
}
