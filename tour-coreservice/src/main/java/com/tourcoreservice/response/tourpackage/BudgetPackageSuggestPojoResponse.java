package com.tourcoreservice.response.tourpackage;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.tourpackage.BudgetPackageSuggestPojo;

public class BudgetPackageSuggestPojoResponse  extends AbstractPojoResponse{
	BudgetPackageSuggestPojo budgetBasedPackagePojo;

	public BudgetPackageSuggestPojo getBudgetBasedPackagePojo() {
		return budgetBasedPackagePojo;
	}

	public void setBudgetBasedPackagePojo(BudgetPackageSuggestPojo budgetBasedPackagePojo) {
		this.budgetBasedPackagePojo = budgetBasedPackagePojo;
	}

}
