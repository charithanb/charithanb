package com.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.repository.ThemeRepository;
import com.tourcoreservice.entity.Theme;

@Service
public class ThemeService {

	@Autowired
	private ThemeRepository themeRepository;

	public List<Theme> listAllTheme() {
		return themeRepository.findAll();
	}

	public Theme saveTheme(Theme theme) {
		return themeRepository.save(theme);
	}

	public Theme UpdateTheme(Theme theme) {
		return themeRepository.save(theme);
	}

	public Theme getThemeById(long id) {
		return themeRepository.findById(id);
	}

	public void deleteTheme(long id) {
		themeRepository.deleteById(id);
	}
}
