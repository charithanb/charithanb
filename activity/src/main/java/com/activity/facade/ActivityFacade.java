package com.activity.facade;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.activity.service.ActivityService;
import com.tourcoreservice.entity.Activity;
import com.tourcoreservice.pojo.activity.ActivityPojo;
import com.tourcoreservice.response.activity.ActivityIdPojoResponse;
import com.tourcoreservice.response.activity.ActivityListPojoResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class ActivityFacade {

	@Autowired
	ActivityService activityService;

	public ActivityListPojoResponse allActivities() {
		ActivityListPojoResponse activityListPojoResponse=new ActivityListPojoResponse();
		List<Activity> activityList=activityService.allActivities();
		List<ActivityPojo> activityPojolist=ObjectMapperUtils.mapAll(activityList, ActivityPojo.class);
		activityListPojoResponse.setActivityPojo(activityPojolist);
		return activityListPojoResponse;
	}

	public ActivityIdPojoResponse create(ActivityPojo activityPojo) {
		ActivityIdPojoResponse activityIdPojoResponse=new ActivityIdPojoResponse();
		Activity activity= ObjectMapperUtils.map(activityPojo, Activity.class);
		activity=activityService.create(activity);
		activityIdPojoResponse.setActivityId(activity.getId());
		return activityIdPojoResponse;
	}

	
}
