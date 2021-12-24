package com.tourcoreservice.response.tourpackage;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.tourpackage.DurationPackageSuggestPojo;

public class DurationPackageSuggestPojoResponse extends AbstractPojoResponse{
	DurationPackageSuggestPojo durationPojo;

	public DurationPackageSuggestPojo getDurationPojo() {
		return durationPojo;
	}

	public void setDurationPojo(DurationPackageSuggestPojo durationPojo) {
		this.durationPojo = durationPojo;
	}

	


}
