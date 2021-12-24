package com.order.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

}
