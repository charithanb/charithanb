package com.tour.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.tour.service.Main_placeService;
import com.tour.util.ObjectMapperUtils;
import com.tourcoreservice.entity.Main_Place;
import com.tourcoreservice.generic.pojo.ResponseMessagePojo;
import com.tourcoreservice.main_place.pojo.Main_placePojo;
import com.tourcoreservice.main_place.response.Main_placeListResponse;
import com.tourcoreservice.main_place.response.Main_placeResponse;

@Component
public class Main_placeFacade {
	@Autowired
	Main_placeService Main_placeService;

	public Main_placeListResponse listAllMainPlaces() {
		Main_placeListResponse main_placeListResponse = new Main_placeListResponse();
		List<Main_Place> main_PlaceEntity = Main_placeService.listAllMainPlace();
		List<Main_placePojo> main_placePojo = ObjectMapperUtils.mapAll(main_PlaceEntity, Main_placePojo.class);
		main_placeListResponse.setMain_placePojo(main_placePojo);
		return main_placeListResponse;
	}

	public Main_placeResponse getMain_place(long id) {
		Main_placeResponse main_placeResponse = new Main_placeResponse();
		Main_Place main_PlaceEntity = Main_placeService.getMain_placeById(id);
		Main_placePojo main_placePojo = ObjectMapperUtils.map(main_PlaceEntity, Main_placePojo.class);
		main_placeResponse.setMain_placePojo(main_placePojo);
		return main_placeResponse;
		
	}

	public Main_placeResponse saveMain_place(Main_placePojo main_placePojo) {
		Main_Place main_PlaceEntity = ObjectMapperUtils.map(main_placePojo, Main_Place.class);
		Main_Place main_placeserviceEntity = Main_placeService.saveMain_place(main_PlaceEntity);
		Main_placePojo main_placeservicePojo = ObjectMapperUtils.map(main_placeserviceEntity, Main_placePojo.class);
		return createDeleteUpdateResponse(main_placeservicePojo, "Created successfully");
	}

	private Main_placeResponse createDeleteUpdateResponse(Main_placePojo main_placeservicePojo, String message) {
		Main_placeResponse main_placeResponse = new Main_placeResponse();
		List<ResponseMessagePojo> successMessaages = new ArrayList<>();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		responseMessagePojo.setSuccessMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessaages.add(responseMessagePojo);
		main_placeResponse.setMain_placePojo(main_placeservicePojo);
		main_placeResponse.setSuccessMessaages(successMessaages);
		return main_placeResponse;
	}

	public Main_placeResponse updateMain_Place(Main_placePojo main_placePojo) {
		Main_placeResponse main_placeResponse = new Main_placeResponse();
		Main_Place main_PlaceEntity = ObjectMapperUtils.map(main_placePojo, Main_Place.class);
		Main_Place main_placeserviceEntity = Main_placeService.updateMain_place(main_PlaceEntity);
		Main_placePojo main_placeservicePojo = ObjectMapperUtils.map(main_placeserviceEntity, Main_placePojo.class);
		main_placeResponse.setMain_placePojo(main_placeservicePojo);
		return main_placeResponse;
	}

	public void deleteMain_Place(long id) {
		Main_placeService.deleteMain_Place(id);

	}

}
