package com.tour.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.Place;

@Repository
public interface PlaceRepositoty extends JpaRepository<Place, Long> {
	Place findById(long id);
}
