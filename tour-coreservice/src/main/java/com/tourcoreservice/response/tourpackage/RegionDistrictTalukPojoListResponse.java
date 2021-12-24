package com.tourcoreservice.response.tourpackage;

import java.util.List;
import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.tourpackage.DistrictPojo;
import com.tourcoreservice.pojo.tourpackage.RegionPojo;
import com.tourcoreservice.pojo.tourpackage.TalukPojo;

public class RegionDistrictTalukPojoListResponse extends AbstractPojoResponse {

	private List<RegionPojo> regionPojoPojolist;
	private List<DistrictPojo> districtPojoList;
	private List<TalukPojo> talukPojoList;

	public List<RegionPojo> getRegionPojoPojolist() {
		return regionPojoPojolist;
	}

	public void setRegionPojoPojolist(List<RegionPojo> regionPojoPojolist) {
		this.regionPojoPojolist = regionPojoPojolist;
	}

	public List<DistrictPojo> getDistrictPojoList() {
		return districtPojoList;
	}

	public void setDistrictPojoList(List<DistrictPojo> districtPojoList) {
		this.districtPojoList = districtPojoList;
	}

	public List<TalukPojo> getTalukPojoList() {
		return talukPojoList;
	}

	public void setTalukPojoList(List<TalukPojo> talukPojoList) {
		this.talukPojoList = talukPojoList;
	}

}
