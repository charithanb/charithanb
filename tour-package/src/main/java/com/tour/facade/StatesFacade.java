package com.tour.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.tour.service.StatesService;
import com.tour.util.ObjectMapperUtils;
import com.tourcoreservice.entity.Country;
import com.tourcoreservice.entity.States;
import com.tourcoreservice.exception.tourpackage.DataAlreadyExistException;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.tourpackage.StatesPojo;
import com.tourcoreservice.response.tourpackage.StatesPojoListResponse;
import com.tourcoreservice.response.tourpackage.StatesPojoResponse;

@Component
public class StatesFacade {

	@Autowired
	StatesService statesService;

	public StatesPojoResponse saveState(StatesPojo statePojo) {
		ifStatesExist(statePojo.getName());
		States statesEntity = ObjectMapperUtils.map(statePojo, States.class);
		States statesServiceEntity = statesService.saveStates(statesEntity);
		StatesPojo statesPojo = ObjectMapperUtils.map(statesServiceEntity, StatesPojo.class);
		return createDeleteUpdateResponse(statesPojo, "Created successfully");
	}

	private void ifStatesExist(String name) {
		// TODO Auto-generated method stub
		States state = statesService.findStateByName(name);
		if (!ObjectUtils.isEmpty(state)) {
			throw new DataAlreadyExistException("Data already exists");
		}
	}

	public StatesPojoListResponse listAllStates() {
		StatesPojoListResponse statesListResponse = new StatesPojoListResponse();
		List<States> statesEntity = statesService.listAllStates();
		List<StatesPojo> statesPojo = ObjectMapperUtils.mapAll(statesEntity, StatesPojo.class);
		statesListResponse.setStatesPojo(statesPojo);
		return statesListResponse;
	}

	public StatesPojoResponse getState(Long id) {
		StatesPojoResponse stateResponse = new StatesPojoResponse();
		States stateEntity = statesService.getStateById(id);
		StatesPojo statesPojo = ObjectMapperUtils.map(stateEntity, StatesPojo.class);
		stateResponse.setStatesPojo(statesPojo);
		return stateResponse;
	}

	public StatesPojoResponse updateState(StatesPojo statesPojo) {

		/*
		 * States statesEntity = ObjectMapperUtils.map(statesPojo, States.class); States
		 * stateServiceEntity = statesService.UpdateStateById(statesEntity); StatesPojo
		 * statePojo = ObjectMapperUtils.map(stateServiceEntity, StatesPojo.class);
		 * return createDeleteUpdateResponse(statePojo,"Updated successfully");
		 */
		States state = statesService.getStateById(statesPojo.getId());
		if (!ObjectUtils.isEmpty(state.getCountry())) {
			deleteExistingCountry(state, state.getCountry());

		}
		ObjectMapperUtils.map(statesPojo, state);
		state = statesService.UpdateStateById(state);
		statesPojo = ObjectMapperUtils.map(state, StatesPojo.class);
		return createDeleteUpdateResponse(statesPojo, "Updated successfully");
	}

	private void deleteExistingCountry(States state, Country country) {
		country = null;
		state.setCountry(country);
		statesService.saveStates(state);
	}

	public StatesPojoResponse deleteState(long id) {
		statesService.deleteStateById(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");
	}

	private StatesPojoResponse createDeleteUpdateResponse(StatesPojo statesPojo, String message) {
		StatesPojoResponse statesResponse = new StatesPojoResponse();
		List<ResponseMessagePojo> successMessaages = new ArrayList<>();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		responseMessagePojo.setSuccessMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessaages.add(responseMessagePojo);
		statesResponse.setStatesPojo(statesPojo);
		statesResponse.setSuccessMessaages(successMessaages);
		return statesResponse;
	}

}
