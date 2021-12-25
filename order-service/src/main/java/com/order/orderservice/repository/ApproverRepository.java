package com.order.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.Approver;

@Repository
public interface ApproverRepository extends JpaRepository<Approver, Long> {

}
