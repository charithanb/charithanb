package com.tourcoreservice.response.tourpackage;

import java.util.List;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.tourpackage.CategoryPojo;

public class CategoryPojoListResponse extends AbstractPojoResponse{

	List<CategoryPojo> categoryPojo;

	public List<CategoryPojo> getCategoryPojo() {
		return categoryPojo;
	}

	public void setCategoryPojo(List<CategoryPojo> categoryPojo) {
		this.categoryPojo = categoryPojo;
	} 
	
}
