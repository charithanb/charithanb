package com.tourcoreservice.response.events;

import java.util.List;

import com.tourcoreservice.pojo.events.EventThemesPojo;

public class EventsThemeListResponse {
	 
	List<EventThemesPojo> eThemesPojo;

	public List<EventThemesPojo> geteThemesPojo() {
		return eThemesPojo;
	}

	public void seteThemesPojo(List<EventThemesPojo> eThemesPojo) {
		this.eThemesPojo = eThemesPojo;
	}
	

}
