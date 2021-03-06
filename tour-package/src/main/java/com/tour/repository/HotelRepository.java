package com.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
	Hotel findById(long id);
}
