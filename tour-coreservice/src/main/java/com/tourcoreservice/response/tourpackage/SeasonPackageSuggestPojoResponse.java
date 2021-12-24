package com.tourcoreservice.response.tourpackage;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.tourpackage.SeasonPackageSuggestPojo;

public class SeasonPackageSuggestPojoResponse extends AbstractPojoResponse{
	SeasonPackageSuggestPojo seasonPojo;

	public SeasonPackageSuggestPojo getSeasonPojo() {
		return seasonPojo;
	}

	public void setSeasonPojo(SeasonPackageSuggestPojo seasonPojo) {
		this.seasonPojo = seasonPojo;
	}
	

}
