package com.order.orderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.ApproverRegion;

@Repository
public interface ApproversRegionRepository extends JpaRepository<ApproverRegion, Long> {

	ApproverRegion findByregionName(String regionName);


}
