package com.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {
	Asset findById(long id);
}
