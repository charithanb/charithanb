package com.tour.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.District;

@Repository
public interface DistrictRepository  extends JpaRepository<District, Long>{

	Optional<District> findByName(String name);
	


}
