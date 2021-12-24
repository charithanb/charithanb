package com.events.westernevents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.events.EventPackages;

@Repository
public interface EventPackageRepository extends JpaRepository<EventPackages, Long> {

}
