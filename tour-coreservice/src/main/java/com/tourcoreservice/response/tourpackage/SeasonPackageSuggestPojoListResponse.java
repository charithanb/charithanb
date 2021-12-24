package com.tourcoreservice.response.tourpackage;

import java.util.List;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.tourpackage.SeasonPackageSuggestPojo;

public class SeasonPackageSuggestPojoListResponse extends AbstractPojoResponse {
	List<SeasonPackageSuggestPojo> seasonPojo;

	public List<SeasonPackageSuggestPojo> getSeasonPojo() {
		return seasonPojo;
	}

	public void setSeasonPojo(List<SeasonPackageSuggestPojo> seasonPojo) {
		this.seasonPojo = seasonPojo;
	}
	
	

}
