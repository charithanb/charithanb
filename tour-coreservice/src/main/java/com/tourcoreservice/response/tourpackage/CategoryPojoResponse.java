package com.tourcoreservice.response.tourpackage;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.tourpackage.CategoryPojo;

public class CategoryPojoResponse extends AbstractPojoResponse {

	CategoryPojo categoryPojo;

	public CategoryPojo getCategoryPojo() {
		return categoryPojo;
	}

	public void setCategoryPojo(CategoryPojo categoryPojo) {
		this.categoryPojo = categoryPojo;
	}
}
