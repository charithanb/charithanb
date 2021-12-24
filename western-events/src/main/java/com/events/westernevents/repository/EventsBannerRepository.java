package com.events.westernevents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.events.EventBanners;

@Repository
public interface EventsBannerRepository extends JpaRepository<EventBanners, Long> {

}
