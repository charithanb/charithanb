package com.events.westernevents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.events.EventThemes;

@Repository
public interface EventsThemeRepository extends JpaRepository<EventThemes, Long>  {

}
