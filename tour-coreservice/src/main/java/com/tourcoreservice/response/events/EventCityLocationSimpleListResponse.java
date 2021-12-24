package com.tourcoreservice.response.events;

import java.util.List;

import com.tourcoreservice.pojo.events.EventCityLocationOnlyPojo;

public class EventCityLocationSimpleListResponse {

	List<EventCityLocationOnlyPojo> eLocationPojos;

	public List<EventCityLocationOnlyPojo> geteLocationPojos() {
		return eLocationPojos;
	}

	public void seteLocationPojos(List<EventCityLocationOnlyPojo> eLocationPojos) {
		this.eLocationPojos = eLocationPojos;
	}
	
}
