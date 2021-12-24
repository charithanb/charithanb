package com.tourcoreservice.response.tourpackage;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.tourpackage.PlacePojo;

public class PlacePojoResponce extends AbstractPojoResponse {

	PlacePojo placePojo;

	public PlacePojo getPlacePojo() {
		return placePojo;
	}

	public void setPlacePojo(PlacePojo placePojo) {
		this.placePojo = placePojo;
	}
}
