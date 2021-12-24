package com.events.westernevents.facad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.events.westernevents.service.MainEventPubsService;
import com.tourcoreservice.entity.events.MainEventPubs;
import com.tourcoreservice.pojo.events.MainEventPubsPojo;
import com.tourcoreservice.response.events.MainEventPubsListResponse;
import com.tourcoreservice.response.events.MainEventPubsResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class MainEventPubsFacad {

	@Autowired
	MainEventPubsService mEventPubsService;
	
	public MainEventPubsListResponse listAllPubs() {
		MainEventPubsListResponse mEventPubsListResponse = new MainEventPubsListResponse();
		List<MainEventPubs> mEventPubs = mEventPubsService.listAll();
		List<MainEventPubsPojo> mEventPubsPojos = ObjectMapperUtils.mapAll(mEventPubs, MainEventPubsPojo.class);
		mEventPubsListResponse.setmEventPubsPojos(mEventPubsPojos);
		return mEventPubsListResponse;
	}
	
	public MainEventPubsResponse getPub(long id) {
		MainEventPubsResponse mEventPubsResponse = new MainEventPubsResponse();
		MainEventPubs mEventPubs = mEventPubsService.getById(id);
		MainEventPubsPojo mEventPubsPojo = ObjectMapperUtils.map(mEventPubs,MainEventPubsPojo.class);
		mEventPubsResponse.setmEventPubsPojo(mEventPubsPojo);
		return mEventPubsResponse;
	}

	public MainEventPubsResponse savepub(MainEventPubsPojo pubsPojo) {
		MainEventPubsResponse mEventPubsResponse = new MainEventPubsResponse();
		MainEventPubs mEventPubs = ObjectMapperUtils.map(pubsPojo, MainEventPubs.class);
		MainEventPubs mEventPubs2 = mEventPubsService.create(mEventPubs);
		MainEventPubsPojo mEventPubsPojo = ObjectMapperUtils.map(mEventPubs2,MainEventPubsPojo.class);
		mEventPubsResponse.setmEventPubsPojo(mEventPubsPojo);
		return mEventPubsResponse;
	}

	public MainEventPubsResponse updatePub(MainEventPubsPojo pubsPojo) {
		MainEventPubsResponse mEventPubsResponse = new MainEventPubsResponse();
		MainEventPubs mEventPubs = ObjectMapperUtils.map(pubsPojo, MainEventPubs.class);
		MainEventPubs mEventPubs2 = mEventPubsService.Update(mEventPubs);
		MainEventPubsPojo mEventPubsPojo = ObjectMapperUtils.map(mEventPubs2,MainEventPubsPojo.class);
		mEventPubsResponse.setmEventPubsPojo(mEventPubsPojo);
		return mEventPubsResponse;
	}

	public void delete(long id) {
		
		mEventPubsService.delete(id);
	}
	
	
}
