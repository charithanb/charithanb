package com.tourcoreservice.response.tourpackage;

import java.util.List;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.tourpackage.StatesPojo;

public class StatesPojoListResponse extends AbstractPojoResponse{

	List<StatesPojo> statesPojo;

	public List<StatesPojo> getStatesPojo() {
		return statesPojo;
	}

	public void setStatesPojo(List<StatesPojo> statesPojo) {
		this.statesPojo = statesPojo;
	}

}
