package com.events.westernevents.facad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.events.westernevents.service.EventsThemeService;
import com.tourcoreservice.entity.events.EventThemes;
import com.tourcoreservice.pojo.events.EventThemeNoImagePojo;
import com.tourcoreservice.pojo.events.EventThemesPojo;
import com.tourcoreservice.response.events.EventThemeNoImageListResponse;
import com.tourcoreservice.response.events.EventsThemeListResponse;
import com.tourcoreservice.response.events.EventsThemeResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class EventThemesFacad {

	@Autowired
	EventsThemeService eThemeService;
	
	public EventsThemeListResponse listAll() {
		EventsThemeListResponse eListResponse = new EventsThemeListResponse();
		List<EventThemes> eThemes = eThemeService.listAll();
		List<EventThemesPojo> eThemesPojos = ObjectMapperUtils.mapAll(eThemes, EventThemesPojo.class);
		eListResponse.seteThemesPojo(eThemesPojos);
		return eListResponse;
	}
	
	public EventThemeNoImageListResponse listAllNoImage() {
		EventThemeNoImageListResponse eListResponse = new EventThemeNoImageListResponse();
		List<EventThemes> eThemes = eThemeService.listAll();
		List<EventThemeNoImagePojo> eThemesPojos = ObjectMapperUtils.mapAll(eThemes, EventThemeNoImagePojo.class);
		eListResponse.seteThemeNoImagePojo(eThemesPojos);
		return eListResponse;
	}
	
	
	public EventsThemeResponse getTheme(long id) {
		EventsThemeResponse eThemeResponse = new EventsThemeResponse();
		EventThemes eThemes = eThemeService.getById(id);
		EventThemesPojo eThemesPojo = ObjectMapperUtils.map(eThemes,EventThemesPojo.class);
		eThemeResponse.seteThemesPojo(eThemesPojo);
		return eThemeResponse;
	}

	public EventsThemeResponse saveTheme(EventThemesPojo ePojo) {
		EventsThemeResponse eThemeResponse = new EventsThemeResponse();
		EventThemes eThemes = ObjectMapperUtils.map(ePojo, EventThemes.class);
		EventThemes eThemes2 = eThemeService.create(eThemes);
		EventThemesPojo eThemesPojo = ObjectMapperUtils.map(eThemes2,EventThemesPojo.class);
		eThemeResponse.seteThemesPojo(eThemesPojo);
		return eThemeResponse;
	}

	public EventsThemeResponse updateBlog(EventThemesPojo ePojo) {
		EventsThemeResponse eThemeResponse = new EventsThemeResponse();
		EventThemes eThemes = ObjectMapperUtils.map(ePojo, EventThemes.class);
		EventThemes eThemes2 = eThemeService.Update(eThemes);
		EventThemesPojo mEventBlogsPojo = ObjectMapperUtils.map(eThemes2,EventThemesPojo.class);
		eThemeResponse.seteThemesPojo(mEventBlogsPojo);
		return eThemeResponse;
	}

	public void delete(long id) {
		
		eThemeService.delete(id);
	}
}
