package com.order.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.ApproverHirarchy;

@Repository
public interface ApproverHirarchyRepository extends JpaRepository<ApproverHirarchy, Long> {

}
