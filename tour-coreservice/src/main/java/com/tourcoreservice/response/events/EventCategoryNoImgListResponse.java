package com.tourcoreservice.response.events;

import java.util.List;

import com.tourcoreservice.pojo.events.EventCatogoryNoimagePojo;

public class EventCategoryNoImgListResponse {
	List<EventCatogoryNoimagePojo> eCatogoryPojos;

	public List<EventCatogoryNoimagePojo> geteCatogoryPojos() {
		return eCatogoryPojos;
	}

	public void seteCatogoryPojos(List<EventCatogoryNoimagePojo> eCatogoryPojos) {
		this.eCatogoryPojos = eCatogoryPojos;
	}
	
}
