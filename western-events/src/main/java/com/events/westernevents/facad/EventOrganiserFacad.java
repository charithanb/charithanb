package com.events.westernevents.facad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.events.westernevents.service.EventOrganiserService;
import com.tourcoreservice.entity.events.EventOrganiser;
import com.tourcoreservice.pojo.events.EventOrganiserPojo;
import com.tourcoreservice.response.events.EventOrganiserListResponse;
import com.tourcoreservice.response.events.EventOrganiserResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class EventOrganiserFacad {
	
	@Autowired
	EventOrganiserService eOrganiserService;
	
	public EventOrganiserListResponse listAll() {
		EventOrganiserListResponse eOrganiserListResponse = new EventOrganiserListResponse();
		List<EventOrganiser> eOrganisers = eOrganiserService.listAll();
		List<EventOrganiserPojo> eOrganiserPojos = ObjectMapperUtils.mapAll(eOrganisers, EventOrganiserPojo.class);
		eOrganiserListResponse.seteOrganiserPojos(eOrganiserPojos);
		return eOrganiserListResponse;
	}
	
	
	
	public EventOrganiserResponse getOrganiser(long id) {
		EventOrganiserResponse eListResponse = new EventOrganiserResponse();
		EventOrganiser eOrganiser = eOrganiserService.getById(id);
		EventOrganiserPojo eOrganiserPojos = ObjectMapperUtils.map(eOrganiser,EventOrganiserPojo.class);
		eListResponse.seteOrganiserPojo(eOrganiserPojos);
		return eListResponse;
	}

	public EventOrganiserResponse saveOrganiser(EventOrganiserPojo ePojo) {
		EventOrganiserResponse eOrganiserResponse = new EventOrganiserResponse();
		EventOrganiser eOrganiser = ObjectMapperUtils.map(ePojo, EventOrganiser.class);
		EventOrganiser eOrganiser2 = eOrganiserService.create(eOrganiser);
		EventOrganiserPojo eOrganiserPojo = ObjectMapperUtils.map(eOrganiser2,EventOrganiserPojo.class);
		eOrganiserResponse.seteOrganiserPojo(eOrganiserPojo);
		return eOrganiserResponse;
	}

	public EventOrganiserResponse updateOrganiser(EventOrganiserPojo ePojo) {
		EventOrganiserResponse eOrganiserResponse = new EventOrganiserResponse();
		EventOrganiser eOrganiser = ObjectMapperUtils.map(ePojo, EventOrganiser.class);
		EventOrganiser eOrganiser2 = eOrganiserService.Update(eOrganiser);
		EventOrganiserPojo eOrganiserPojo = ObjectMapperUtils.map(eOrganiser2,EventOrganiserPojo.class);
		eOrganiserResponse.seteOrganiserPojo(eOrganiserPojo);
		return eOrganiserResponse;
	}

	public void delete(long id) {
		
		eOrganiserService.delete(id);
	}

}
