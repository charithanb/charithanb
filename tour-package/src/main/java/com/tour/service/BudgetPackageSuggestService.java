package com.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.repository.BudgetPackageSuggestRepository;
import com.tourcoreservice.entity.BudgetPackageSuggest;

@Service
public class BudgetPackageSuggestService {

	@Autowired
	BudgetPackageSuggestRepository basedPackageRepository;

	public BudgetPackageSuggest create(BudgetPackageSuggest budgetBasedPackage) {
		return basedPackageRepository.save(budgetBasedPackage);
	}

	public BudgetPackageSuggest getById(long id) {
		return basedPackageRepository.findById(id);
	}

	public List<BudgetPackageSuggest> getAll() {
		return basedPackageRepository.findAll();
	}

	public void delete(long id) {
		basedPackageRepository.deleteById(id);

	}

	public BudgetPackageSuggest Update(BudgetPackageSuggest budgetBasedPackage) {
		return basedPackageRepository.save(budgetBasedPackage);

	}

	public void save(BudgetPackageSuggest budgetBasedPackage) {
		basedPackageRepository.save(budgetBasedPackage);

		
	}

}
