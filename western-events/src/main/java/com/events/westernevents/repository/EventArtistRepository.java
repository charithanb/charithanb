package com.events.westernevents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.events.EventArtist;

@Repository
public interface EventArtistRepository extends JpaRepository<EventArtist, Long> {

}
