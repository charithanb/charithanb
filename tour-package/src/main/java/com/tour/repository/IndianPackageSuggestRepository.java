package com.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.IndianPackageSuggest;

@Repository
public interface IndianPackageSuggestRepository extends JpaRepository<IndianPackageSuggest,Long > {
	IndianPackageSuggest findById(long id);
}
