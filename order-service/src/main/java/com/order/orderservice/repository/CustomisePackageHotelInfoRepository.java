package com.order.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.CustomisePackageHotelInfo;

@Repository
public interface CustomisePackageHotelInfoRepository  extends JpaRepository<CustomisePackageHotelInfo , Long> {

}
