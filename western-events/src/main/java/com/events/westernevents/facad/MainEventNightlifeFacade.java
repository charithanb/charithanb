package com.events.westernevents.facad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.events.westernevents.service.MainEventNightlifeService;
import com.tourcoreservice.entity.events.MainEventsNightlifeEntity;
import com.tourcoreservice.pojo.events.MainEventsNightlifePojo;
import com.tourcoreservice.response.events.MainEventNightlifeResponse;
import com.tourcoreservice.response.events.MainEventNightlifeResponseList;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class MainEventNightlifeFacade {
	@Autowired
	MainEventNightlifeService mainEventNightlifeService;
	
	public MainEventNightlifeResponseList listAll() {
		MainEventNightlifeResponseList mEventNightlifeResponseList = new MainEventNightlifeResponseList();
		List<MainEventsNightlifeEntity> mainEventsNightlifeEntities = mainEventNightlifeService.listAll();
		List<MainEventsNightlifePojo> mainEventsNightlifePojos = ObjectMapperUtils.mapAll(mainEventsNightlifeEntities, MainEventsNightlifePojo.class);
		mEventNightlifeResponseList.setMainEventsNightlifePojos(mainEventsNightlifePojos);
		return mEventNightlifeResponseList;
	}
	
	public MainEventNightlifeResponse getNightlife(long id) {
		MainEventNightlifeResponse mEventNightlifeResponse = new MainEventNightlifeResponse();
		MainEventsNightlifeEntity mEventsNightlifeEntity = mainEventNightlifeService.getById(id);
		MainEventsNightlifePojo mainEventsNightlifePojo = ObjectMapperUtils.map(mEventsNightlifeEntity,MainEventsNightlifePojo.class);
		mEventNightlifeResponse.setMainEventsNightlifePojo(mainEventsNightlifePojo);
		return mEventNightlifeResponse;
	}

	public MainEventNightlifeResponse saveNightlife(MainEventsNightlifePojo mEventsNightlifePojo) {
		MainEventNightlifeResponse mEventNightlifeResponse = new MainEventNightlifeResponse();
		MainEventsNightlifeEntity mainEventsNightlifeEntity = ObjectMapperUtils.map(mEventsNightlifePojo, MainEventsNightlifeEntity.class);
		MainEventsNightlifeEntity mEventsNightlifeEntity = mainEventNightlifeService.create(mainEventsNightlifeEntity);
		MainEventsNightlifePojo mainEventsNightlifePojo = ObjectMapperUtils.map(mEventsNightlifeEntity,MainEventsNightlifePojo.class);
		mEventNightlifeResponse.setMainEventsNightlifePojo(mainEventsNightlifePojo);
		return mEventNightlifeResponse;
	}

	public MainEventNightlifeResponse updateNightlife(MainEventsNightlifePojo nightlifePojo) {
		MainEventNightlifeResponse mainEventsNightlifeResponse = new MainEventNightlifeResponse();
		MainEventsNightlifeEntity mainEventsNightlifeEntity = ObjectMapperUtils.map(nightlifePojo, MainEventsNightlifeEntity.class);
		MainEventsNightlifeEntity mainEventsNight = mainEventNightlifeService.Update(mainEventsNightlifeEntity);
		MainEventsNightlifePojo mainEventsNightlifePojo = ObjectMapperUtils.map(mainEventsNight,MainEventsNightlifePojo.class);
		mainEventsNightlifeResponse.setMainEventsNightlifePojo(mainEventsNightlifePojo);
		return mainEventsNightlifeResponse;
	}

	public void delete(long id) {
		
		mainEventNightlifeService.delete(id);
	}
	
	

}
