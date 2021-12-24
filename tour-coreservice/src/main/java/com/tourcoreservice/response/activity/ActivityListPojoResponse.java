package com.tourcoreservice.response.activity;

import java.util.List;

import com.tourcoreservice.pojo.activity.ActivityPojo;

public class ActivityListPojoResponse {

	List<ActivityPojo> activityPojo;

	public List<ActivityPojo> getActivityPojo() {
		return activityPojo;
	}

	public void setActivityPojo(List<ActivityPojo> activityPojo) {
		this.activityPojo = activityPojo;
	}

}
