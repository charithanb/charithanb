package com.tourcoreservice.response.tourpackage;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.tourpackage.PackageSuggestPojo;

public class PackageSuggestPojoResponse extends AbstractPojoResponse{
	
	PackageSuggestPojo packageSuggestPojo;

	public PackageSuggestPojo getPackageSuggestPojo() {
		return packageSuggestPojo;
	}

	public void setPackageSuggestPojo(PackageSuggestPojo packageSuggestPojo) {
		this.packageSuggestPojo = packageSuggestPojo;
	}
	
	

}
