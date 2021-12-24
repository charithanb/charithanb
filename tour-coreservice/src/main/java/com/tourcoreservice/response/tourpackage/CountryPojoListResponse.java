package com.tourcoreservice.response.tourpackage;

import java.util.List;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.tourpackage.CountryPojo;

public class CountryPojoListResponse extends AbstractPojoResponse{

	List<CountryPojo> countryPojo;

	public List<CountryPojo> getCountryPojo() {
		return countryPojo;
	}

	public void setCountryPojo(List<CountryPojo> countryPojo) {
		this.countryPojo = countryPojo;
	}
	
}
