package com.events.westernevents.facad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.events.westernevents.service.EventCategoryService;
import com.tourcoreservice.entity.events.EventCatogory;
import com.tourcoreservice.pojo.events.EventCatogoryNoimagePojo;
import com.tourcoreservice.pojo.events.EventCatogoryPojo;
import com.tourcoreservice.response.events.EventCategoryListResponse;
import com.tourcoreservice.response.events.EventCategoryNoImgListResponse;
import com.tourcoreservice.response.events.EventCategoryResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class EventCategoryFacad {
	@Autowired
	EventCategoryService eCategoryService;
	
	public EventCategoryListResponse listAll() {
		EventCategoryListResponse eCategoryListResponse = new EventCategoryListResponse();
		List<EventCatogory> eCatogories = eCategoryService.listAll();
		List<EventCatogoryPojo> eCatogoryPojos = ObjectMapperUtils.mapAll(eCatogories, EventCatogoryPojo.class);
		eCategoryListResponse.seteCatogoryPojos(eCatogoryPojos);
		return eCategoryListResponse;
	}
	
	public EventCategoryNoImgListResponse listAllNoImage() {
		EventCategoryNoImgListResponse eListResponse = new EventCategoryNoImgListResponse();
		List<EventCatogory> eArtists = eCategoryService.listAll();
		List<EventCatogoryNoimagePojo> eArtistNoImagePojo = ObjectMapperUtils.mapAll(eArtists, EventCatogoryNoimagePojo.class);
		eListResponse.seteCatogoryPojos(eArtistNoImagePojo);
		return eListResponse;
	}
	
	
	public EventCategoryResponse getCategory(long id) {
		EventCategoryResponse eCategoryResponse = new EventCategoryResponse();
		EventCatogory eCatogory = eCategoryService.getById(id);
		EventCatogoryPojo eCatogoryPojo = ObjectMapperUtils.map(eCatogory,EventCatogoryPojo.class);
		eCategoryResponse.seteCatogoryPojo(eCatogoryPojo);
		return eCategoryResponse;
	}

	public EventCategoryResponse saveCategory(EventCatogoryPojo ePojo) {
		EventCategoryResponse eCategoryResponse = new EventCategoryResponse();
		EventCatogory eCatogory = ObjectMapperUtils.map(ePojo, EventCatogory.class);
		EventCatogory eCatogory2 = eCategoryService.create(eCatogory);
		EventCatogoryPojo eCatogoryPojo = ObjectMapperUtils.map(eCatogory2,EventCatogoryPojo.class);
		eCategoryResponse.seteCatogoryPojo(eCatogoryPojo);;
		return eCategoryResponse;
	}

	public EventCategoryResponse updateCategory(EventCatogoryPojo ePojo) {
		EventCategoryResponse eCategoryResponse = new EventCategoryResponse();
		EventCatogory eCatogory = ObjectMapperUtils.map(ePojo, EventCatogory.class);
		EventCatogory eCatogory2 = eCategoryService.Update(eCatogory);
		EventCatogoryPojo eCatogoryPojo = ObjectMapperUtils.map(eCatogory2,EventCatogoryPojo.class);
		eCategoryResponse.seteCatogoryPojo(eCatogoryPojo);
		return eCategoryResponse;
	}

	public void delete(long id) {
		
		eCategoryService.delete(id);
	}
}
