package com.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.PackageSuggest;

@Repository
public interface PackageSuggestRepository extends JpaRepository<PackageSuggest, Long> {

}
