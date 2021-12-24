package com.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tour.facade.ThemeFacade;
import com.tourcoreservice.pojo.tourpackage.ThemePojo;
import com.tourcoreservice.response.tourpackage.ThemePojoListResponse;
import com.tourcoreservice.response.tourpackage.ThemePojoResponse;

@RestController
@RequestMapping("/theme")
public class ThemeController {

	@Autowired
	ThemeFacade themeFacade;
	
	@GetMapping
	public  ThemePojoListResponse allTheme() {
        return themeFacade.listAllThemes();
    }
	@GetMapping("/{id}")
    public ThemePojoResponse getTheme(@PathVariable long id) {
        return themeFacade.getTheme(id);
        
    }
    @PostMapping
    public ThemePojoResponse create(@RequestBody ThemePojo theme) {
    	return themeFacade.saveTheme(theme);
    }
    @PutMapping("/{id}")
    public ThemePojoResponse update(@RequestBody ThemePojo theme, @PathVariable long id) {
    	theme.setId(id);
    	return themeFacade.updateTheme(theme);
       
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
    	themeFacade.deleteTheme(id);
    }
}
