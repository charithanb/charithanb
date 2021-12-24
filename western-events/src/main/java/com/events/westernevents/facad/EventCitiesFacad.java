package com.events.westernevents.facad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.events.westernevents.service.EventCitiesService;
import com.tourcoreservice.entity.events.EventCities;
import com.tourcoreservice.pojo.events.EventCitiesOnlyPojo;
import com.tourcoreservice.pojo.events.EventCitiesPojo;
import com.tourcoreservice.response.events.EventCitiesListResponse;
import com.tourcoreservice.response.events.EventCitiesResponse;
import com.tourcoreservice.response.events.EventCitiesSimpleListResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Repository
public class EventCitiesFacad {

	@Autowired
	EventCitiesService eService;
	
	public EventCitiesListResponse listAll() {
		EventCitiesListResponse eListResponse = new EventCitiesListResponse();
		List<EventCities> eCities = eService.listAll();
		List<EventCitiesPojo> eCitiesPojos = ObjectMapperUtils.mapAll(eCities, EventCitiesPojo.class);
		eListResponse.seteCitiesPojos(eCitiesPojos);
		return eListResponse;
	}
	
	public EventCitiesSimpleListResponse SimpelistAll() {
		EventCitiesSimpleListResponse eListResponse = new EventCitiesSimpleListResponse();
		List<EventCities> eCities = eService.listAll();
		List<EventCitiesOnlyPojo> eCitiesPojos = ObjectMapperUtils.mapAll(eCities, EventCitiesOnlyPojo.class);
		eListResponse.seteCitiesPojos(eCitiesPojos);
		return eListResponse;
	}
	
	
	public EventCitiesResponse getCities(long id) {
		EventCitiesResponse eResponse = new EventCitiesResponse();
		EventCities eCities = eService.getById(id);
		EventCitiesPojo eCitiesPojo = ObjectMapperUtils.map(eCities,EventCitiesPojo.class);
		eResponse.seteCitiesPojo(eCitiesPojo);
		return eResponse;
	}

	public EventCitiesResponse saveCities(EventCitiesPojo ePojo) {
		EventCitiesResponse eResponse = new EventCitiesResponse();
		EventCities eCities = ObjectMapperUtils.map(ePojo, EventCities.class);
		EventCities eCities2 = eService.create(eCities);
		EventCitiesPojo eCitiesPojo = ObjectMapperUtils.map(eCities2,EventCitiesPojo.class);
		eResponse.seteCitiesPojo(eCitiesPojo);
		return eResponse;
	}

	public EventCitiesResponse updateCities(EventCitiesPojo ePojo) {
		EventCitiesResponse eResponse = new EventCitiesResponse();
		EventCities eCities = ObjectMapperUtils.map(ePojo, EventCities.class);
		EventCities eCities2 = eService.Update(eCities);
		EventCitiesPojo eCitiesPojo = ObjectMapperUtils.map(eCities2,EventCitiesPojo.class);
		eResponse.seteCitiesPojo(eCitiesPojo);
		return eResponse;
	}

	public void delete(long id) {
		
		eService.delete(id);
	}




	
}
