package com.tour.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.tour.service.ThemeService;
import com.tour.util.ObjectMapperUtils;
import com.tourcoreservice.entity.Theme;
import com.tourcoreservice.exception.tourpackage.DataAlreadyExistException;
import com.tourcoreservice.exception.tourpackage.DataDoesNotExistException;
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
		ifThemeDoesNotExists(id);
		ThemePojoResponse themeResponce = new ThemePojoResponse();
		Theme themeEntity = themeService.getThemeById(id);
		ThemePojo ThemePojo = ObjectMapperUtils.map(themeEntity, ThemePojo.class);
		themeResponce.setThemePojo(ThemePojo);
		return themeResponce;

	}

	private void ifThemeDoesNotExists(long id) {
		Theme theme = themeService.getThemeById(id);
		if (ObjectUtils.isEmpty(theme)) {
			throw new DataDoesNotExistException("Data doesn't exist");
		}
	}

	public ThemePojoResponse saveTheme(ThemePojo themepojo) {
		ifThemeAlreadyExists(themepojo.getId());
		ThemePojoResponse themeResponce = new ThemePojoResponse();
		Theme themeEntity = ObjectMapperUtils.map(themepojo, Theme.class);
		Theme themeServiceEntity = themeService.saveTheme(themeEntity);
		ThemePojo themeServicePojo = ObjectMapperUtils.map(themeServiceEntity, ThemePojo.class);
		themeResponce.setThemePojo(themeServicePojo);
		return themeResponce;
	}

	private void ifThemeAlreadyExists(long id) {
		Theme theme = themeService.getThemeById(id);
		if (!ObjectUtils.isEmpty(theme)) {
			throw new DataAlreadyExistException("Data already exists");
		}

	}

	public ThemePojoResponse updateTheme(ThemePojo themepojo) {
		ifThemeDoesNotExists(themepojo.getId());
		ThemePojoResponse themeResponce = new ThemePojoResponse();
		Theme themeEntity = ObjectMapperUtils.map(themepojo, Theme.class);
		Theme themeServiceEntity = themeService.UpdateTheme(themeEntity);
		ThemePojo themeServicePojo = ObjectMapperUtils.map(themeServiceEntity, ThemePojo.class);
		themeResponce.setThemePojo(themeServicePojo);
		return themeResponce;
	}

	public void deleteTheme(long id) {
		ifThemeDoesNotExists(id);
		themeService.deleteTheme(id);

	}
}
