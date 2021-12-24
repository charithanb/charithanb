package com.tour.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.tour.service.PlaceService;
import com.tour.util.ObjectMapperUtils;
import com.tourcoreservice.entity.District;
import com.tourcoreservice.entity.MainPlace;
import com.tourcoreservice.entity.Place;
import com.tourcoreservice.entity.Taluk;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.tourpackage.MainPlacePojo;
import com.tourcoreservice.pojo.tourpackage.PlacePojo;
import com.tourcoreservice.response.tourpackage.MainPlacePojoListResponse;
import com.tourcoreservice.response.tourpackage.MainPlacePojoResponse;
import com.tourcoreservice.response.tourpackage.PlacePojoListResponse;
import com.tourcoreservice.response.tourpackage.PlacePojoResponce;

@Component
public class PlaceFacede {

	@Autowired
	private PlaceService placeService;

	public PlacePojoListResponse listAllPlaces() {
		PlacePojoListResponse placeListResponse = new PlacePojoListResponse();
		List<Place> PlaceEntity = placeService.listAllPlace();
		List<PlacePojo> placePojo = ObjectMapperUtils.mapAll(PlaceEntity, PlacePojo.class);
		placeListResponse.setPlacePojos(placePojo);
		return placeListResponse;
	}

	public PlacePojoResponce getPlace(long id) {
		PlacePojoResponce placeResponce = new PlacePojoResponce();
		Place placeEntity = placeService.getPlaceById(id);
		PlacePojo placePojo = ObjectMapperUtils.map(placeEntity, PlacePojo.class);
		placeResponce.setPlacePojo(placePojo);
		return placeResponce;

	}

	public PlacePojoResponce savePlace(PlacePojo placepojo) {
		Place placeEntity = ObjectMapperUtils.map(placepojo, Place.class);
		Place placeserviceEntity = placeService.savePlace(placeEntity);
		PlacePojo placeservicePojo = ObjectMapperUtils.map(placeserviceEntity, PlacePojo.class);
		return createDeleteUpdateResponse(placeservicePojo, "Created successfully");
	}

	public PlacePojoResponce updatePlace(PlacePojo placepojo) {
		Place place=placeService.getPlaceById(placepojo.getId());
		if (!ObjectUtils.isEmpty(place.getDistrict())) {
			deleteExistingMAinplace(place,place.getDistrict());
		}
		PlacePojoResponce placeResponce = new PlacePojoResponce();
		ObjectMapperUtils.map(placepojo, place);
		Place placeserviceEntity = placeService.UpdatePlace(place);
		PlacePojo placeservicePojo = ObjectMapperUtils.map(placeserviceEntity, PlacePojo.class);
		placeResponce.setPlacePojo(placeservicePojo);
		return placeResponce;
	}

	private void deleteExistingMAinplace(Place place, District district) {
		district=null;
		place.setDistrict(null);                                                                                                                                                                                           
		placeService.savePlace(place);
	}

	public void deletePlace(long id) {
		placeService.deletePlace(id);

	}

	private PlacePojoResponce createDeleteUpdateResponse(PlacePojo placeservicePojo, String message) {
		PlacePojoResponce placeResponce = new PlacePojoResponce();
		List<ResponseMessagePojo> successMessaages = new ArrayList<>();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		responseMessagePojo.setSuccessMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessaages.add(responseMessagePojo);
		placeResponce.setPlacePojo(placeservicePojo);
		placeResponce.setSuccessMessaages(successMessaages);
		return placeResponce;
	}

	public MainPlacePojoResponse mainplaceCreae(MainPlacePojo mainPlacePojo) {
		MainPlace mainplace = ObjectMapperUtils.map(mainPlacePojo, MainPlace.class);
		MainPlace mainplaceEntity = placeService.saveMainPlace(mainplace);
		mainPlacePojo = ObjectMapperUtils.map(mainplaceEntity, MainPlacePojo.class);
		return createDeleteUpdateMainPlaceResponse(mainPlacePojo, "Created successfully");
	}

	private MainPlacePojoResponse createDeleteUpdateMainPlaceResponse(MainPlacePojo mainPlacePojo, String message) {
		MainPlacePojoResponse mainplaceResponce = new MainPlacePojoResponse();
		List<ResponseMessagePojo> successMessaages = new ArrayList<>();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		responseMessagePojo.setSuccessMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessaages.add(responseMessagePojo);
		mainplaceResponce.setMainPlacePojo(mainPlacePojo);
		mainplaceResponce.setSuccessMessaages(successMessaages);
		return mainplaceResponce;
	}

	public MainPlacePojoListResponse allMainPlaces() {
		MainPlacePojoListResponse mainPlacePojoListResponse = new MainPlacePojoListResponse();
		List<MainPlace> mainPlaceEntityList = placeService.allMainPlaces();
		List<MainPlacePojo> mainPlacePojoList = ObjectMapperUtils.mapAll(mainPlaceEntityList, MainPlacePojo.class);
		mainPlacePojoListResponse.setMainPlacePojo(mainPlacePojoList);
		return mainPlacePojoListResponse;
	}

	public MainPlacePojoResponse updateMainPlace(MainPlacePojo mainPlacePojo) {
		MainPlace mainPlace = placeService.getMainPlaceById(mainPlacePojo.getId());
		if (!ObjectUtils.isEmpty(mainPlace.getTaluk())) {
			deleteExistingTaluk(mainPlace,mainPlace.getTaluk());
		}
		
		ObjectMapperUtils.map(mainPlacePojo, mainPlace);
		mainPlace = placeService.updateMainPlace(mainPlace);
		mainPlacePojo = ObjectMapperUtils.map(mainPlace, mainPlacePojo);
		return createDeleteUpdateMainPlaceResponse(mainPlacePojo, "updated Successfully");
	}

	private void deleteExistingTaluk(MainPlace mainPlace, Taluk taluk) {
		taluk=null;
		mainPlace.setTaluk(taluk);
		placeService.saveMainPlace(mainPlace);
	}

	public MainPlacePojoResponse deleteMainPlace(long id) {
		MainPlace mainPlace = placeService.getMainPlaceById(id);
		placeService.deleteMainPlace(mainPlace);
		return createDeleteUpdateMainPlaceResponse(null, "Deleted Successfully");
	}
}
