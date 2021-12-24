package com.tour.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tour.service.ThemeService;
import com.tour.util.ObjectMapperUtils;
import com.tourcoreservice.entity.Theme;
import com.tourcoreservice.pojo.tourpackage.ThemePojo;
import com.tourcoreservice.response.tourpackage.ThemePojoListResponse;
import com.tourcoreservice.response.tourpackage.ThemePojoResponse;

@Component
public class ThemeFacade {

	@Autowired
	ThemeService themeService;

	public ThemePojoListResponse listAllThemes() {
		ThemePojoListResponse themeListResponse = new ThemePojoListResponse();
		List<Theme> themeEntity = themeService.listAllTheme();
		List<ThemePojo> themePojo = ObjectMapperUtils.mapAll(themeEntity, ThemePojo.class);
		themeListResponse.setThemePojo(themePojo);
		return themeListResponse;
	}

	public ThemePojoResponse getTheme(long id) {
		ThemePojoResponse themeResponce = new ThemePojoResponse();
		Theme themeEntity = themeService.getThemeById(id);
		ThemePojo ThemePojo = ObjectMapperUtils.map(themeEntity, ThemePojo.class);
		themeResponce.setThemePojo(ThemePojo);
		return themeResponce;

	}

	public ThemePojoResponse saveTheme(ThemePojo themepojo) {
		ThemePojoResponse themeResponce = new ThemePojoResponse();
		Theme themeEntity = ObjectMapperUtils.map(themepojo, Theme.class);
		Theme themeServiceEntity = themeService.saveTheme(themeEntity);
		ThemePojo themeServicePojo = ObjectMapperUtils.map(themeServiceEntity, ThemePojo.class);
		themeResponce.setThemePojo(themeServicePojo);
		return themeResponce;
	}

	public ThemePojoResponse updateTheme(ThemePojo themepojo) {
		ThemePojoResponse themeResponce = new ThemePojoResponse();
		Theme themeEntity = ObjectMapperUtils.map(themepojo, Theme.class);
		Theme themeServiceEntity = themeService.UpdateTheme(themeEntity);
		ThemePojo themeServicePojo = ObjectMapperUtils.map(themeServiceEntity, ThemePojo.class);
		themeResponce.setThemePojo(themeServicePojo);
		return themeResponce;
	}

	public void deleteTheme(long id) {
		themeService.deleteTheme(id);

	}
}
