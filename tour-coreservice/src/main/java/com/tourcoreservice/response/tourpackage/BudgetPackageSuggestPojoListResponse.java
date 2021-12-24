package com.tourcoreservice.response.tourpackage;

import java.util.List;

import com.tourcoreservice.pojo.tourpackage.BudgetPackageSuggestPojo;

public class BudgetPackageSuggestPojoListResponse {
	List<BudgetPackageSuggestPojo> budgetBasedPackagePojo;

	public List<BudgetPackageSuggestPojo> getBudgetBasedPackagePojo() {
		return budgetBasedPackagePojo;
	}

	public void setBudgetBasedPackagePojo(List<BudgetPackageSuggestPojo> budgetBasedPackagePojo) {
		this.budgetBasedPackagePojo = budgetBasedPackagePojo;
	}

	
}
