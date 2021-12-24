package com.events.westernevents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.events.MainEventsNightlifeEntity;

@Repository
public interface MainEventNightlifeRepository extends JpaRepository<MainEventsNightlifeEntity, Long> {

}

