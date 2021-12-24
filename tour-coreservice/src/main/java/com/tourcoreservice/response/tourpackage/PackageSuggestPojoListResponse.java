package com.tourcoreservice.response.tourpackage;

import java.util.List;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.tourpackage.PackageSuggestPojo;

public class PackageSuggestPojoListResponse extends AbstractPojoResponse {
	
	List<PackageSuggestPojo> packageSuggestPojo;

	public List<PackageSuggestPojo> getPackageSuggestPojo() {
		return packageSuggestPojo;
	}

	public void setPackageSuggestPojo(List<PackageSuggestPojo> packageSuggestPojo) {
		this.packageSuggestPojo = packageSuggestPojo;
	}
	

}
