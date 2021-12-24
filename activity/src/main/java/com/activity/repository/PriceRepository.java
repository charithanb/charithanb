package com.activity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

}
