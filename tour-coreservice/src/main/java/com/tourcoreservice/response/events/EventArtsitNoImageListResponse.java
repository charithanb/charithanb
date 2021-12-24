package com.tourcoreservice.response.events;

import java.util.List;

import com.tourcoreservice.pojo.events.EventArtistNoImagePojo;

public class EventArtsitNoImageListResponse {

	List<EventArtistNoImagePojo> eArtistNoImagePojo;

	

	public List<EventArtistNoImagePojo> geteArtistNoImagePojo() {
		return eArtistNoImagePojo;
	}

	public void seteArtistNoImagePojo(List<EventArtistNoImagePojo> eArtistNoImagePojo2) {
		this.eArtistNoImagePojo = eArtistNoImagePojo2;
	}
	
}
