package com.events.westernevents.facad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.events.westernevents.service.MainEventDjsService;
import com.tourcoreservice.entity.events.MainEventDjs;
import com.tourcoreservice.pojo.events.MainEventDjsPojo;
import com.tourcoreservice.response.events.MainEventDjsListResponse;
import com.tourcoreservice.response.events.MainEventDjsResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class MainEventDjsFacad {

	@Autowired
	MainEventDjsService mEventDjsService;
	
	public MainEventDjsListResponse listAll() {
		MainEventDjsListResponse mDjsListResponse = new MainEventDjsListResponse();
		List<MainEventDjs> mEventDjs = mEventDjsService.listAll();
		List<MainEventDjsPojo> mEventDjsPojos = ObjectMapperUtils.mapAll(mEventDjs, MainEventDjsPojo.class);
		mDjsListResponse.setmDjsPojos(mEventDjsPojos);
		return mDjsListResponse;
	}
	
	public MainEventDjsResponse getDj(long id) {
		MainEventDjsResponse mEventDjsResponse = new MainEventDjsResponse();
		MainEventDjs mEventDjs = mEventDjsService.getById(id);
		MainEventDjsPojo mEventDjsPojo = ObjectMapperUtils.map(mEventDjs,MainEventDjsPojo.class);
		mEventDjsResponse.setmDjsPojo(mEventDjsPojo);
		return mEventDjsResponse;
	}

	public MainEventDjsResponse saveDj(MainEventDjsPojo mDjsPojo) {
		MainEventDjsResponse mEventDjsResponse = new MainEventDjsResponse();
		MainEventDjs mEventDjs = ObjectMapperUtils.map(mDjsPojo, MainEventDjs.class);
		MainEventDjs mEventDjs2 = mEventDjsService.create(mEventDjs);
		MainEventDjsPojo mEventDjsPojo = ObjectMapperUtils.map(mEventDjs2,MainEventDjsPojo.class);
		mEventDjsResponse.setmDjsPojo(mEventDjsPojo);
		return mEventDjsResponse;
	}

	public MainEventDjsResponse updateDj(MainEventDjsPojo mDjsPojo) {
		MainEventDjsResponse mEventDjsResponse = new MainEventDjsResponse();
		MainEventDjs mEventDjs = ObjectMapperUtils.map(mDjsPojo, MainEventDjs.class);
		MainEventDjs mEventDjs2 = mEventDjsService.Update(mEventDjs);
		MainEventDjsPojo mEventDjsPojo = ObjectMapperUtils.map(mEventDjs2,MainEventDjsPojo.class);
		mEventDjsResponse.setmDjsPojo(mEventDjsPojo);
		return mEventDjsResponse;
	}

	public void delete(long id) {
		
		mEventDjsService.delete(id);
	}
	
}
