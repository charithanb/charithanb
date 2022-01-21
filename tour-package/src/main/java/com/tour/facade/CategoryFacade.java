package com.tour.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.tour.service.CategoryService;
import com.tour.util.ObjectMapperUtils;
import com.tourcoreservice.entity.Category;
import com.tourcoreservice.exception.tourpackage.DataAlreadyExistException;
import com.tourcoreservice.exception.tourpackage.DataDoesNotExistException;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.tourpackage.CategoryPojo;
import com.tourcoreservice.response.tourpackage.CategoryPojoListResponse;
import com.tourcoreservice.response.tourpackage.CategoryPojoResponse;

@Component
public class CategoryFacade {

	@Autowired
	private CategoryService categoryService;

	public CategoryPojoListResponse listAllCategories() {
		CategoryPojoListResponse categoryListResponse = new CategoryPojoListResponse();
		List<Category> categoriesEntity = categoryService.listAllPlace();
		List<CategoryPojo> categoryPojo = ObjectMapperUtils.mapAll(categoriesEntity, CategoryPojo.class);
		categoryListResponse.setCategoryPojo(categoryPojo);
		return categoryListResponse;
	}

	public CategoryPojoResponse getCategory(long id) {
		ifDataDoesNotExist(id);
		CategoryPojoResponse categoryResponse = new CategoryPojoResponse();
		Category categoriesEntity = categoryService.getCategoryById(id);
		CategoryPojo categoryPojo = ObjectMapperUtils.map(categoriesEntity, CategoryPojo.class);
		categoryResponse.setCategoryPojo(categoryPojo);
		return categoryResponse;

	}

	private void ifDataDoesNotExist(long id) {
		Category category = categoryService.getCategoryById(id);
		if(ObjectUtils.isEmpty(category)) {
			throw new DataDoesNotExistException("Data doesn't exist");
		}
		
	}

	public CategoryPojoResponse saveCategory(CategoryPojo category) {
		ifDataAlreadyExists(category.getId());
		Category categoriesEntity = ObjectMapperUtils.map(category, Category.class);
		Category categoryServiceEntity = categoryService.saveCategory(categoriesEntity);
		CategoryPojo categoryPojo = ObjectMapperUtils.map(categoryServiceEntity, CategoryPojo.class);
		return createDeleteUpdateResponse(categoryPojo, "Created successfully");
	}

	private void ifDataAlreadyExists(long id) {
		Category category = categoryService.getCategoryById(id);
		if (!ObjectUtils.isEmpty(category)) {
			throw new DataAlreadyExistException("Data already exists");
		}

	}

	public CategoryPojoResponse updateCategory(CategoryPojo category) {
		ifDataDoesNotExist(category.getId());
		Category categoriesEntity = ObjectMapperUtils.map(category, Category.class);
		Category categoryserviceEntity = categoryService.UpdateCategory(categoriesEntity);
		CategoryPojo categoryPojo = ObjectMapperUtils.map(categoryserviceEntity, CategoryPojo.class);
		return createDeleteUpdateResponse(categoryPojo, "Updated successfully");
	}

	public CategoryPojoResponse deleteCategory(long id) {
		ifDataDoesNotExist(id);
		categoryService.deleteCategory(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");
	}

	private CategoryPojoResponse createDeleteUpdateResponse(CategoryPojo categoryPojo, String message) {
		CategoryPojoResponse categoryResponse = new CategoryPojoResponse();
		List<ResponseMessagePojo> successMessaages = new ArrayList<>();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		responseMessagePojo.setSuccessMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessaages.add(responseMessagePojo);
		categoryResponse.setCategoryPojo(categoryPojo);
		categoryResponse.setSuccessMessaages(successMessaages);
		return categoryResponse;
	}
}
