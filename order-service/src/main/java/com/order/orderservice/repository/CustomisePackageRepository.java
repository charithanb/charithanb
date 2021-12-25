package com.order.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.CustomisePackage;

@Repository
public interface CustomisePackageRepository extends JpaRepository<CustomisePackage, Long>{

}
