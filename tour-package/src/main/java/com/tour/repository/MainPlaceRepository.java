package com.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.MainPlace;

@Repository
public interface MainPlaceRepository extends JpaRepository<MainPlace, Long> {

	MainPlace findByid(long id);

}
