package com.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.repository.CategoryRepository;
import com.tourcoreservice.entity.Category;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> listAllPlace() {
		return categoryRepository.findAll();
	}

	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}

	public Category UpdateCategory(Category category) {
		return categoryRepository.save(category);
	}

	public Category getCategoryById(long id) {
		return categoryRepository.findById(id).get();
	}

	public void deleteCategory(long id) {
		categoryRepository.deleteById(id);
	}
}
