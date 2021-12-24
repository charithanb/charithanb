package com.tourcoreservice.response.events;
import java.util.List;

import com.tourcoreservice.pojo.events.MainEventPubsPojo;
public class MainEventPubsListResponse {
	List<MainEventPubsPojo>  mEventPubsPojos;

	public List<MainEventPubsPojo> getmEventPubsPojos() {
		return mEventPubsPojos;
	}

	public void setmEventPubsPojos(List<MainEventPubsPojo> mEventPubsPojos) {
		this.mEventPubsPojos = mEventPubsPojos;
	}
	

}
