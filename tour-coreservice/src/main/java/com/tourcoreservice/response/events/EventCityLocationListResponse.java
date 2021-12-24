package com.tourcoreservice.response.events;

import java.util.List;

import com.tourcoreservice.pojo.events.EventCityLocationPojo;

public class EventCityLocationListResponse {

	List<EventCityLocationPojo> eLocationPojos;

	public List<EventCityLocationPojo> geteLocationPojos() {
		return eLocationPojos;
	}

	public void seteLocationPojos(List<EventCityLocationPojo> eLocationPojos) {
		this.eLocationPojos = eLocationPojos;
	}
	
}
