package com.events.westernevents.facad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.events.westernevents.service.MainEventPartiesService;
import com.tourcoreservice.entity.events.MainEventsPartiesEntity;
import com.tourcoreservice.pojo.events.MainEventsPartyPojo;
import com.tourcoreservice.response.events.MainEventsPartyResponse;
import com.tourcoreservice.response.events.MainEventsPartyResponseList;
import com.tourcoreservice.util.ObjectMapperUtils;



@Component
public class MainEventPartiesFacade {
	@Autowired
	MainEventPartiesService mainEventPartiesService;
	
	public MainEventsPartyResponseList listAllParties() {
		MainEventsPartyResponseList mainEventsPartyResponseList = new MainEventsPartyResponseList();
		List<MainEventsPartiesEntity> mainEventsParties = mainEventPartiesService.listAll();
		List<MainEventsPartyPojo> mainEventsPartyPojos = ObjectMapperUtils.mapAll(mainEventsParties, MainEventsPartyPojo.class);
		mainEventsPartyResponseList.setMainEventsPartyPojos(mainEventsPartyPojos);
		return mainEventsPartyResponseList;
	}
	
	public MainEventsPartyResponse getParty(long id) {
		MainEventsPartyResponse mainEventsPartyResponse = new MainEventsPartyResponse();
		MainEventsPartiesEntity mainEventsPartiesEntity = mainEventPartiesService.getById(id);
		MainEventsPartyPojo mainEventsPartyPojo = ObjectMapperUtils.map(mainEventsPartiesEntity,MainEventsPartyPojo.class);
		mainEventsPartyResponse.setMainEventsPartyPojo(mainEventsPartyPojo);
		return mainEventsPartyResponse;
	}

	public MainEventsPartyResponse saveparty(MainEventsPartyPojo partyPojo) {
		MainEventsPartyResponse mainEventsPartyResponse = new MainEventsPartyResponse();
		MainEventsPartiesEntity mainEventsPartiesEntity = ObjectMapperUtils.map(partyPojo, MainEventsPartiesEntity.class);
		MainEventsPartiesEntity mainEventsParty = mainEventPartiesService.create(mainEventsPartiesEntity);
		MainEventsPartyPojo mainEventsPartyPojo = ObjectMapperUtils.map(mainEventsParty,MainEventsPartyPojo.class);
		mainEventsPartyResponse.setMainEventsPartyPojo(mainEventsPartyPojo);
		return mainEventsPartyResponse;
	}

	public MainEventsPartyResponse updateCategory(MainEventsPartyPojo partyPojo) {
		MainEventsPartyResponse mainEventsPartyResponse = new MainEventsPartyResponse();
		MainEventsPartiesEntity mainEventsPartiesEntity = ObjectMapperUtils.map(partyPojo, MainEventsPartiesEntity.class);
		MainEventsPartiesEntity mainEventsParty = mainEventPartiesService.Update(mainEventsPartiesEntity);
		MainEventsPartyPojo mainEventsPartyPojo = ObjectMapperUtils.map(mainEventsParty,MainEventsPartyPojo.class);
		mainEventsPartyResponse.setMainEventsPartyPojo(mainEventsPartyPojo);
		return mainEventsPartyResponse;
	}

	public void delete(long id) {
		
		mainEventPartiesService.delete(id);
	}
	
	
}
