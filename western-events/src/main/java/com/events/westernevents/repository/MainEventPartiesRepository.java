package com.events.westernevents.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.events.MainEventsPartiesEntity;


@Repository
public interface MainEventPartiesRepository extends JpaRepository<MainEventsPartiesEntity, Long> {

}
