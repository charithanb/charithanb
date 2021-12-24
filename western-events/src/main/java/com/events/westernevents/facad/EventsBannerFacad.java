package com.events.westernevents.facad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.events.westernevents.service.EventsBannerService;
import com.tourcoreservice.entity.events.EventBanners;
import com.tourcoreservice.pojo.events.EventbannerPojo;
import com.tourcoreservice.response.events.EventsBannerListResponse;
import com.tourcoreservice.response.events.EventsBannerResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class EventsBannerFacad {
 
	@Autowired
	EventsBannerService eService;
	
	public EventsBannerListResponse listAll() {
		EventsBannerListResponse mListResponse = new EventsBannerListResponse();
		List<EventBanners> mBanners = eService.listAll();
		List<EventbannerPojo> mEventbannerPojos = ObjectMapperUtils.mapAll(mBanners , EventbannerPojo.class);
		mListResponse.setEventbannerPojos(mEventbannerPojos);
		return mListResponse;
	}
	
	
	
	
	public EventsBannerResponse getBanner(long id) {
		EventsBannerResponse eResponse = new EventsBannerResponse();
		EventBanners eBanners = eService.getById(id);
		EventbannerPojo eventbannerPojo = ObjectMapperUtils.map(eBanners,EventbannerPojo.class);
		eResponse.setEventbannerPojo(eventbannerPojo);
		return eResponse;
	}

	public EventsBannerResponse saveBanner(EventbannerPojo ePojo) {
		EventsBannerResponse eResponse = new EventsBannerResponse();
		EventBanners eBanners = ObjectMapperUtils.map(ePojo, EventBanners.class);
		EventBanners eBanners2 = eService.create(eBanners);
		EventbannerPojo eventbannerPojo = ObjectMapperUtils.map(eBanners2,EventbannerPojo.class);
		eResponse.setEventbannerPojo(eventbannerPojo);
		return eResponse;
	}

	public EventsBannerResponse updateBanner(EventbannerPojo ePojo) {
		EventsBannerResponse eResponse = new EventsBannerResponse();
		EventBanners eBanners = ObjectMapperUtils.map(ePojo, EventBanners.class);
		EventBanners eBanners2 = eService.Update(eBanners);
		EventbannerPojo mEventBlogsPojo = ObjectMapperUtils.map(eBanners2,EventbannerPojo.class);
		eResponse.setEventbannerPojo(mEventBlogsPojo);
		return eResponse;
	}

	public void delete(long id) {
		eService.delete(id);
	}
	
}
