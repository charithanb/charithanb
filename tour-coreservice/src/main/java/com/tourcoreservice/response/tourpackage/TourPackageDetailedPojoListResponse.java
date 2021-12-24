package com.tourcoreservice.response.tourpackage;

import java.util.List;

import com.tourcoreservice.pojo.tourpackage.TourpackagePojo;

public class TourPackageDetailedPojoListResponse {
	List<TourpackagePojo> tourpackagePojo;

	public List<TourpackagePojo> getTourpackagePojo() {
		return tourpackagePojo;
	}

	public void setTourpackagePojo(List<TourpackagePojo> tourpackagePojo) {
		this.tourpackagePojo = tourpackagePojo;
	}
	
}
