package com.tourcoreservice.response.tourpackage;

import java.util.List;

import com.tourcoreservice.pojo.tourpackage.TourPackagePartialPojo;

public class TourpackagePojoListResponse {
	List<TourPackagePartialPojo> tourpackagePojo;

	public List<TourPackagePartialPojo> getTourpackagePojo() {
		return tourpackagePojo;
	}

	public void setTourpackagePojo(List<TourPackagePartialPojo> tourPackagePojo2) {
		this.tourpackagePojo = tourPackagePojo2;
	}
	

}
