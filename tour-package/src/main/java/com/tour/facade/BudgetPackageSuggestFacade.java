package com.tour.facade;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.tour.service.BudgetPackageSuggestService;
import com.tour.service.PlaceService;
import com.tour.util.ObjectMapperUtils;
import com.tourcoreservice.entity.BudgetPackageSuggest;
import com.tourcoreservice.entity.Place;
import com.tourcoreservice.exception.tourpackage.DataAlreadyExistException;
import com.tourcoreservice.exception.tourpackage.DataDoesNotExistException;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.tourpackage.BudgetPackageSuggestPojo;
import com.tourcoreservice.pojo.tourpackage.PlacePojo;
import com.tourcoreservice.response.tourpackage.BudgetPackageSuggestPojoListResponse;
import com.tourcoreservice.response.tourpackage.BudgetPackageSuggestPojoResponse;

@Component
public class BudgetPackageSuggestFacade {

	@Autowired
	BudgetPackageSuggestService budgetBasedPackageService;

	@Autowired
	PlaceService placeservice;
	
	public BudgetPackageSuggestPojoResponse create(BudgetPackageSuggestPojo budgetBasedPackagePojo) {
		ifAlreadyExists(budgetBasedPackagePojo.getId());
		ifPlaceDoesNotExist(budgetBasedPackagePojo.getPlace());
		BudgetPackageSuggest budgetBasedPackage = ObjectMapperUtils.map(budgetBasedPackagePojo, BudgetPackageSuggest.class);
		budgetBasedPackage = budgetBasedPackageService.create(budgetBasedPackage);
		budgetBasedPackagePojo = ObjectMapperUtils.map(budgetBasedPackage, BudgetPackageSuggestPojo.class);
		return createDeleteUpdateResponse(budgetBasedPackagePojo, "Created successfully");
	}

	private void ifPlaceDoesNotExist(PlacePojo place) {
		Place place2 = placeservice.getPlaceById(place.getId());
		if(ObjectUtils.isEmpty(place2)) {
			throw new DataDoesNotExistException("Place doesn't exist");
		}
		
	}

	private void ifAlreadyExists(long id) {
		BudgetPackageSuggest budgetPackageSuggest = budgetBasedPackageService.getById(id);
		if(!ObjectUtils.isEmpty(budgetPackageSuggest)) {
			throw new DataAlreadyExistException("Data already exists");
		}
		
	}

	private BudgetPackageSuggestPojoResponse createDeleteUpdateResponse(BudgetPackageSuggestPojo budgetBasedPackagePojo,
			String message) {
		BudgetPackageSuggestPojoResponse budgetBasedPackagePojoResponse = new BudgetPackageSuggestPojoResponse();
		List<ResponseMessagePojo> successMessaages = new ArrayList<>();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		responseMessagePojo.setSuccessMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessaages.add(responseMessagePojo);
		budgetBasedPackagePojoResponse.setBudgetBasedPackagePojo(budgetBasedPackagePojo);
		budgetBasedPackagePojoResponse.setSuccessMessaages(successMessaages);
		return budgetBasedPackagePojoResponse;
	}

	public BudgetPackageSuggestPojoResponse get(long id) {
		ifDataDoesNotExist(id);
		BudgetPackageSuggestPojoResponse budgetBasedPackagePojoResponse = new BudgetPackageSuggestPojoResponse();
		BudgetPackageSuggest budgetBasedPackage = budgetBasedPackageService.getById(id);
		BudgetPackageSuggestPojo budgetBasedPackagePojo = ObjectMapperUtils.map(budgetBasedPackage,
				BudgetPackageSuggestPojo.class);
		budgetBasedPackagePojoResponse.setBudgetBasedPackagePojo(budgetBasedPackagePojo);
		return budgetBasedPackagePojoResponse;
	}

	private void ifDataDoesNotExist(long id) {
		BudgetPackageSuggest budgetPackageSuggest = budgetBasedPackageService.getById(id);
		if(ObjectUtils.isEmpty(budgetPackageSuggest)) {
			throw new DataDoesNotExistException("Data doesn't exist");
		}
		
	}

	public BudgetPackageSuggestPojoListResponse findAll() {
		BudgetPackageSuggestPojoListResponse budgetBasedPackagePojoListResponse = new BudgetPackageSuggestPojoListResponse();
		List<BudgetPackageSuggest> budgetBasedPackage = budgetBasedPackageService.getAll();
		List<BudgetPackageSuggestPojo> budgetBasedPackagePojo = ObjectMapperUtils.mapAll(budgetBasedPackage,
				BudgetPackageSuggestPojo.class);
		budgetBasedPackagePojoListResponse.setBudgetBasedPackagePojo(budgetBasedPackagePojo);
		return budgetBasedPackagePojoListResponse;

	}

	public BudgetPackageSuggestPojoResponse delete(long id) {
		ifDataDoesNotExist(id);
		budgetBasedPackageService.delete(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");

	}

	public BudgetPackageSuggestPojoResponse update(BudgetPackageSuggestPojo budgetBasedPackagePojo) {
		ifDataDoesNotExist(budgetBasedPackagePojo.getId());
		BudgetPackageSuggest budgetBasedPackage = budgetBasedPackageService.getById(budgetBasedPackagePojo.getId());
		deleteExisistingPlace(budgetBasedPackage, budgetBasedPackage.getPlace());
		
		ObjectMapperUtils.map(budgetBasedPackagePojo, budgetBasedPackage);
		budgetBasedPackage = budgetBasedPackageService.Update(budgetBasedPackage);
		budgetBasedPackagePojo = ObjectMapperUtils.map(budgetBasedPackage, BudgetPackageSuggestPojo.class);
		return createDeleteUpdateResponse(budgetBasedPackagePojo, "Updated successfully");
	}

	

	private void deleteExisistingPlace(BudgetPackageSuggest budgetBasedPackage, Place place) {
		place = null;
		budgetBasedPackage.setPlace(place);
		budgetBasedPackageService.save(budgetBasedPackage);

	}

}
