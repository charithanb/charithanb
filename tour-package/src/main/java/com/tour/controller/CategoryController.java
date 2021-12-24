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

import com.tour.facade.CategoryFacade;
import com.tourcoreservice.pojo.tourpackage.CategoryPojo;
import com.tourcoreservice.response.tourpackage.CategoryPojoListResponse;
import com.tourcoreservice.response.tourpackage.CategoryPojoResponse;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	CategoryFacade categoryFacade;

	@GetMapping
	public CategoryPojoListResponse getAll() {
		return categoryFacade.listAllCategories();
	}

	@GetMapping("/{id}")
	public CategoryPojoResponse get(@PathVariable long id) {
		return categoryFacade.getCategory(id);

	}

	@PostMapping
	public CategoryPojoResponse create(@RequestBody CategoryPojo category) {
		return categoryFacade.saveCategory(category);
	}

	@PutMapping("/{id}")
	public CategoryPojoResponse update(@RequestBody CategoryPojo category, @PathVariable long id) {
		category.setId(id);
		return categoryFacade.updateCategory(category);

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		categoryFacade.deleteCategory(id);
	}
}
