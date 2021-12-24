
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

import com.tour.facade.BudgetPackageSuggestFacade;
import com.tourcoreservice.pojo.tourpackage.BudgetPackageSuggestPojo;
import com.tourcoreservice.response.tourpackage.BudgetPackageSuggestPojoListResponse;
import com.tourcoreservice.response.tourpackage.BudgetPackageSuggestPojoResponse;

@RestController
@RequestMapping("/budgetpackageSuggest")
public class BudgetPackageSuggestController {

	@Autowired
	BudgetPackageSuggestFacade budgetBasedPackageFacade;

	@PostMapping
	public BudgetPackageSuggestPojoResponse create(@RequestBody BudgetPackageSuggestPojo budgetBasedPackagePojo) {
		return budgetBasedPackageFacade.create(budgetBasedPackagePojo);
	}

	@GetMapping("/{id}")
	public BudgetPackageSuggestPojoResponse get(@PathVariable long id) {
		return budgetBasedPackageFacade.get(id);
	}

	@GetMapping
	public BudgetPackageSuggestPojoListResponse getAll() {
		return budgetBasedPackageFacade.findAll();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		budgetBasedPackageFacade.delete(id);
	}

	@PutMapping("/{id}")
	public BudgetPackageSuggestPojoResponse update(@RequestBody BudgetPackageSuggestPojo budgetBasedPackagePojo,
			@PathVariable("id") long id) {
		budgetBasedPackagePojo.setId(id);
		return budgetBasedPackageFacade.update(budgetBasedPackagePojo);
	}

}
