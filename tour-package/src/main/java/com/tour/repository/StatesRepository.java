package com.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.States;

@Repository
public interface StatesRepository extends JpaRepository<States,Long>{

	States findByname(String name);

}
