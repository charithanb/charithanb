package com.tourcoreservice.response.events;

import java.util.List;

import com.tourcoreservice.pojo.events.EventOrganiserPojo;

public class EventOrganiserListResponse {

	List<EventOrganiserPojo> eOrganiserPojos;

	public List<EventOrganiserPojo> geteOrganiserPojos() {
		return eOrganiserPojos;
	}

	public void seteOrganiserPojos(List<EventOrganiserPojo> eOrganiserPojos) {
		this.eOrganiserPojos = eOrganiserPojos;
	}
	
}
