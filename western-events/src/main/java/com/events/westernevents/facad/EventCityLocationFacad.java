package com.events.westernevents.facad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.events.westernevents.service.EventCityLocationService;
import com.tourcoreservice.entity.events.EventCityLocation;
import com.tourcoreservice.pojo.events.EventCityLocationOnlyPojo;
import com.tourcoreservice.pojo.events.EventCityLocationPojo;
import com.tourcoreservice.response.events.EventCityLocationListResponse;
import com.tourcoreservice.response.events.EventCityLocationResponse;
import com.tourcoreservice.response.events.EventCityLocationSimpleListResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class EventCityLocationFacad {

	@Autowired
	EventCityLocationService eService;
	
	public EventCityLocationListResponse listAll() {
		EventCityLocationListResponse eListResponse = new EventCityLocationListResponse();
		List<EventCityLocation> eCities = eService.listAll();
		List<EventCityLocationPojo> eCitiesPojos = ObjectMapperUtils.mapAll(eCities, EventCityLocationPojo.class);
		eListResponse.seteLocationPojos(eCitiesPojos);
		return eListResponse;
	}
	
	public EventCityLocationSimpleListResponse SimpelistAll() {
		EventCityLocationSimpleListResponse eListResponse = new EventCityLocationSimpleListResponse();
		List<EventCityLocation> eCities = eService.listAll();
		List<EventCityLocationOnlyPojo> eCitiesPojos = ObjectMapperUtils.mapAll(eCities, EventCityLocationOnlyPojo.class);
		eListResponse.seteLocationPojos(eCitiesPojos);
		return eListResponse;
	}
	
	
	
	public EventCityLocationResponse getCities(long id) {
		EventCityLocationResponse eResponse = new EventCityLocationResponse();
		EventCityLocation eCities = eService.getById(id);
		EventCityLocationPojo eLocationPojo = ObjectMapperUtils.map(eCities,EventCityLocationPojo.class);
		eResponse.seteLocationPojo(eLocationPojo);
		return eResponse;
	}

	public EventCityLocationResponse saveCities(EventCityLocationPojo ePojo) {
		EventCityLocationResponse eResponse = new EventCityLocationResponse();
		EventCityLocation eCities = ObjectMapperUtils.map(ePojo, EventCityLocation.class);
		EventCityLocation eCities2 = eService.create(eCities);
		EventCityLocationPojo eLocationPojo = ObjectMapperUtils.map(eCities2,EventCityLocationPojo.class);
		eResponse.seteLocationPojo(eLocationPojo);
		return eResponse;
	}

	public EventCityLocationResponse updateCities(EventCityLocationPojo ePojo) {
		EventCityLocationResponse eResponse = new EventCityLocationResponse();
		EventCityLocation eCities = ObjectMapperUtils.map(ePojo, EventCityLocation.class);
		EventCityLocation eCities2 = eService.Update(eCities);
		EventCityLocationPojo eLocationPojo = ObjectMapperUtils.map(eCities2,EventCityLocationPojo.class);
		eResponse.seteLocationPojo(eLocationPojo);
		return eResponse;
	}

	public void delete(long id) {
		
		eService.delete(id);
	}
}
