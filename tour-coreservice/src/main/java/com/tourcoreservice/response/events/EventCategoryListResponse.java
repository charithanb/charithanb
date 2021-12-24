
package com.tourcoreservice.response.events;

import java.util.List;

import com.tourcoreservice.pojo.events.EventCatogoryPojo;

public class EventCategoryListResponse {

	List<EventCatogoryPojo> eCatogoryPojos;

	public List<EventCatogoryPojo> geteCatogoryPojos() {
		return eCatogoryPojos;
	}

	public void seteCatogoryPojos(List<EventCatogoryPojo> eCatogoryPojos) {
		this.eCatogoryPojos = eCatogoryPojos;
	}
	
	
}
