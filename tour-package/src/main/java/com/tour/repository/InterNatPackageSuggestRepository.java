package com.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.InterNatPackageSuggest;

@Repository
public interface InterNatPackageSuggestRepository extends JpaRepository<InterNatPackageSuggest,Long > {
	
}
