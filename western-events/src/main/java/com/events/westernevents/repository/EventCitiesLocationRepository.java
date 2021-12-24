package com.events.westernevents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.events.EventCityLocation;

@Repository
public interface EventCitiesLocationRepository extends JpaRepository<EventCityLocation, Long>{

}
