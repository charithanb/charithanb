package com.tourcoreservice.response.tourpackage;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.tourpackage.StatesPojo;

public class StatesPojoResponse extends AbstractPojoResponse {

	StatesPojo statesPojo;

	public StatesPojo getStatesPojo() {
		return statesPojo;
	}

	public void setStatesPojo(StatesPojo statesPojo) {
		this.statesPojo = statesPojo;
	}
	
}
