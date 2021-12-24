package com.events.westernevents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.events.MainEventPubs;

@Repository
public interface MainEventPubsRepository extends JpaRepository<MainEventPubs, Long> {

}
