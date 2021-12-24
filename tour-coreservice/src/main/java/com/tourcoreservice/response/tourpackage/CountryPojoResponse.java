package com.tourcoreservice.response.tourpackage;


import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.tourpackage.CountryPojo;

public class CountryPojoResponse extends AbstractPojoResponse {

	CountryPojo countryPojo;

	public CountryPojo getCountryPojo() {
		return countryPojo;
	}

	public void setCountryPojo(CountryPojo countryPojo) {
		this.countryPojo = countryPojo;
	}
}
