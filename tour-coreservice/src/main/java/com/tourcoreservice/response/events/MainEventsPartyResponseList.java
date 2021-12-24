package com.tourcoreservice.response.events;

import java.util.List;

import com.tourcoreservice.pojo.events.MainEventsPartyPojo;

public class MainEventsPartyResponseList {

	List<MainEventsPartyPojo> mainEventsPartyPojos;

	public List<MainEventsPartyPojo> getMainEventsPartyPojos() {
		return mainEventsPartyPojos;
	}

	public void setMainEventsPartyPojos(List<MainEventsPartyPojo> mainEventsPartyPojos) {
		this.mainEventsPartyPojos = mainEventsPartyPojos;
	}
}
