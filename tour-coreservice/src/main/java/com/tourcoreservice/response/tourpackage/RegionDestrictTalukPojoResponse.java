package com.tourcoreservice.response.tourpackage;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.tourpackage.DistrictPojo;
import com.tourcoreservice.pojo.tourpackage.RegionPojo;
import com.tourcoreservice.pojo.tourpackage.TalukPojo;

public class RegionDestrictTalukPojoResponse extends AbstractPojoResponse {

	private RegionPojo regionPojo;

	private DistrictPojo districtPojo;

	private TalukPojo talukPojo;

	public RegionPojo getRegionPojo() {
		return regionPojo;
	}

	public void setRegionPojo(RegionPojo regionPojo) {
		this.regionPojo = regionPojo;
	}

	public DistrictPojo getDistrictPojo() {
		return districtPojo;
	}

	public void setDistrictPojo(DistrictPojo districtPojo) {
		this.districtPojo = districtPojo;
	}

	public TalukPojo getTalukPojo() {
		return talukPojo;
	}

	public void setTalukPojo(TalukPojo talukPojo) {
		this.talukPojo = talukPojo;
	}

}
