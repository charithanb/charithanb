package com.tourcoreservice.response.events;

import com.tourcoreservice.pojo.events.EventOrganiserPojo;

public class EventOrganiserResponse {

	EventOrganiserPojo eOrganiserPojo;

	public EventOrganiserPojo geteOrganiserPojo() {
		return eOrganiserPojo;
	}

	public void seteOrganiserPojo(EventOrganiserPojo eOrganiserPojo) {
		this.eOrganiserPojo = eOrganiserPojo;
	}
	
}
