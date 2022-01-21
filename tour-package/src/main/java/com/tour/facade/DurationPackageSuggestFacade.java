package com.tour.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.tour.service.DurationPackageSuggestService;
import com.tour.util.ObjectMapperUtils;
import com.tourcoreservice.entity.DurationPackageSuggest;
import com.tourcoreservice.exception.tourpackage.DataAlreadyExistException;
import com.tourcoreservice.exception.tourpackage.DataDoesNotExistException;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.tourpackage.DurationPackageSuggestPojo;
import com.tourcoreservice.response.tourpackage.DurationPackageSuggestPojoResponse;
import com.tourcoreservice.response.tourpackage.DurationSuggestPackagePojoListResponse;

@Component
public class DurationPackageSuggestFacade {

	@Autowired
	DurationPackageSuggestService durationService;

	public DurationPackageSuggestPojoResponse create(DurationPackageSuggestPojo durationPojo) {
		ifDataAlreadyExists(durationPojo.getId());
		DurationPackageSuggest duration = ObjectMapperUtils.map(durationPojo, DurationPackageSuggest.class);
		duration = durationService.create(duration);
		durationPojo = ObjectMapperUtils.map(duration, DurationPackageSuggestPojo.class);
		return createDeleteUpdateResponse(durationPojo, "Created successfully");
	}

	private void ifDataAlreadyExists(long id) {
		DurationPackageSuggest durationPackageSuggest = durationService.getById(id);
		if (!ObjectUtils.isEmpty(durationPackageSuggest)) {
			throw new DataAlreadyExistException("Data already exists");
		}

	}

	private DurationPackageSuggestPojoResponse createDeleteUpdateResponse(DurationPackageSuggestPojo durationPojo,
			String message) {
		DurationPackageSuggestPojoResponse durationPojoResponse = new DurationPackageSuggestPojoResponse();
		List<ResponseMessagePojo> successMessaages = new ArrayList<>();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		responseMessagePojo.setSuccessMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessaages.add(responseMessagePojo);
		durationPojoResponse.setDurationPojo(durationPojo);
		durationPojoResponse.setSuccessMessaages(successMessaages);
		return durationPojoResponse;
	}

	public DurationPackageSuggestPojoResponse get(long id) {
		ifDataDoesNotExist(id);
		DurationPackageSuggestPojoResponse durationPojoResponse = new DurationPackageSuggestPojoResponse();
		DurationPackageSuggest duration = durationService.getById(id);
		DurationPackageSuggestPojo durationPojo = ObjectMapperUtils.map(duration, DurationPackageSuggestPojo.class);
		durationPojoResponse.setDurationPojo(durationPojo);
		return durationPojoResponse;
	}

	private void ifDataDoesNotExist(long id) {
		DurationPackageSuggest durationPackageSuggest = durationService.getById(id);
		if (ObjectUtils.isEmpty(durationPackageSuggest)) {
			throw new DataDoesNotExistException("Data doesn't exist");
		}

	}

	public DurationSuggestPackagePojoListResponse listAll() {
		DurationSuggestPackagePojoListResponse durationPojoListResponse = new DurationSuggestPackagePojoListResponse();
		List<DurationPackageSuggest> duration = durationService.listAll();
		List<DurationPackageSuggestPojo> durationPojo = ObjectMapperUtils.mapAll(duration,
				DurationPackageSuggestPojo.class);
		durationPojoListResponse.setDurationPojo(durationPojo);
		return durationPojoListResponse;
	}

	public DurationPackageSuggestPojoResponse delete(long id) {
		ifDataDoesNotExist(id);
		durationService.delete(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");

	}

	public DurationPackageSuggestPojoResponse update(DurationPackageSuggestPojo durationPojo) {
		ifDataDoesNotExist(durationPojo.getId());
		DurationPackageSuggest duration = durationService.getById(durationPojo.getId());
		ObjectMapperUtils.map(durationPojo, duration);
		duration = durationService.Update(duration);
		durationPojo = ObjectMapperUtils.map(duration, DurationPackageSuggestPojo.class);
		return createDeleteUpdateResponse(durationPojo, "Updated successfully");
	}

}
