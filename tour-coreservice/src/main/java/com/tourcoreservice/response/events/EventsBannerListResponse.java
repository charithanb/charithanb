package com.tourcoreservice.response.events;
import java.util.List;
import com.tourcoreservice.pojo.events.EventbannerPojo;

public class EventsBannerListResponse {

	 List<EventbannerPojo>  eventbannerPojos;

	public List<EventbannerPojo> getEventbannerPojos() {
		return eventbannerPojos;
	}

	public void setEventbannerPojos(List<EventbannerPojo> eventbannerPojos) {
		this.eventbannerPojos = eventbannerPojos;
	}
	 
}
