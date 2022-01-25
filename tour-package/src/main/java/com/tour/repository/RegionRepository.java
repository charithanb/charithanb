package com.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.Regions;

@Repository
public interface RegionRepository extends JpaRepository<Regions,Long> {

	Regions findById(long id);

	Regions findByName(String name);
}
