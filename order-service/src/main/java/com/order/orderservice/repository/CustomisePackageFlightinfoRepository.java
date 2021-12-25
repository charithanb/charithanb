package com.order.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.CustomisePackageFlightinfo;

@Repository
public interface CustomisePackageFlightinfoRepository extends JpaRepository<CustomisePackageFlightinfo, Long> {

}
