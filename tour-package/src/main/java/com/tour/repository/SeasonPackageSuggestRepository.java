package com.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.SeasonPackageSuggest;

@Repository
public interface SeasonPackageSuggestRepository extends JpaRepository<SeasonPackageSuggest, Long> {
	SeasonPackageSuggest findById(long id);
}
