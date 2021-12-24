package com.activity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.activity.facade.ActivityFacade;
import com.tourcoreservice.pojo.activity.ActivityPojo;
import com.tourcoreservice.response.activity.ActivityIdPojoResponse;
import com.tourcoreservice.response.activity.ActivityListPojoResponse;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/activity")
public class ActivityController {
	@Autowired
	ActivityFacade activityFacade;
	
	@GetMapping
	public ActivityListPojoResponse allActivities() {
		return activityFacade.allActivities();	
	}
	
	@PostMapping
	public ActivityIdPojoResponse create(@RequestBody ActivityPojo activityPojo)
	{
		return activityFacade.create(activityPojo);
		
	}

}
