package com.tourcoreservice.response.events;

import java.util.List;

import com.tourcoreservice.pojo.events.EventArtistPojo;

public class EventArtistListResponse {

	List<EventArtistPojo> eArtistPojos;

	public List<EventArtistPojo> geteArtistPojos() {
		return eArtistPojos;
	}

	public void seteArtistPojos(List<EventArtistPojo> eArtistPojos) {
		this.eArtistPojos = eArtistPojos;
	}
	
}
