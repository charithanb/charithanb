package com.events.westernevents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.events.EventCatogory;

@Repository
public interface EventCategoryRepository extends JpaRepository<EventCatogory, Long>{

}
