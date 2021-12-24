package com.activity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.Facility;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long> {

}
