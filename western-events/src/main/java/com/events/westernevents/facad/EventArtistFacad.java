package com.events.westernevents.facad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.events.westernevents.service.EventArtistService;
import com.tourcoreservice.entity.events.EventArtist;
import com.tourcoreservice.pojo.events.EventArtistNoImagePojo;
import com.tourcoreservice.pojo.events.EventArtistPojo;
import com.tourcoreservice.response.events.EventArstistResponse;
import com.tourcoreservice.response.events.EventArtistListResponse;
import com.tourcoreservice.response.events.EventArtsitNoImageListResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class EventArtistFacad {
	
	@Autowired
	EventArtistService eArtistService;
	
	public EventArtistListResponse listAll() {
		EventArtistListResponse eArtistResponse = new EventArtistListResponse();
		List<EventArtist> eArtists = eArtistService.listAll();
		List<EventArtistPojo> eArtistPojos = ObjectMapperUtils.mapAll(eArtists, EventArtistPojo.class);
		eArtistResponse.seteArtistPojos(eArtistPojos);
		return eArtistResponse;
	}
	
	public EventArtsitNoImageListResponse listAllNoImage() {
		EventArtsitNoImageListResponse eListResponse = new EventArtsitNoImageListResponse();
		List<EventArtist> eArtists = eArtistService.listAll();
		List<EventArtistNoImagePojo> eArtistNoImagePojo = ObjectMapperUtils.mapAll(eArtists, EventArtistNoImagePojo.class);
		eListResponse.seteArtistNoImagePojo(eArtistNoImagePojo);
		return eListResponse;
	}
	
	
	public EventArstistResponse getArtist(long id) {
		EventArstistResponse eArstistResponse = new EventArstistResponse();
		EventArtist eArtist = eArtistService.getById(id);
		EventArtistPojo eArtistPojo = ObjectMapperUtils.map(eArtist,EventArtistPojo.class);
		eArstistResponse.seteArtistPojos(eArtistPojo);
		return eArstistResponse;
	}

	public EventArstistResponse saveArtist(EventArtistPojo ePojo) {
		EventArstistResponse eArstistResponse = new EventArstistResponse();
		EventArtist eArtist = ObjectMapperUtils.map(ePojo, EventArtist.class);
		EventArtist eArtist2 = eArtistService.create(eArtist);
		EventArtistPojo eArtistPojo = ObjectMapperUtils.map(eArtist2,EventArtistPojo.class);
		eArstistResponse.seteArtistPojos(eArtistPojo);
		return eArstistResponse;
	}

	public EventArstistResponse updateArtist(EventArtistPojo ePojo) {
		EventArstistResponse eArstistResponse = new EventArstistResponse();
		EventArtist eArtist = ObjectMapperUtils.map(ePojo, EventArtist.class);
		EventArtist eArtist2 = eArtistService.Update(eArtist);
		EventArtistPojo eArtistPojo = ObjectMapperUtils.map(eArtist2,EventArtistPojo.class);
		eArstistResponse.seteArtistPojos(eArtistPojo);
		return eArstistResponse;
	}

	public void delete(long id) {
		
		eArtistService.delete(id);
	}
}
