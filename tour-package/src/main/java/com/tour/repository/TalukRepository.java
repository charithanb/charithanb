package com.tour.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.Taluk;

@Repository
public interface TalukRepository  extends JpaRepository<Taluk, Long>{

	Optional<Taluk> findTalukById(long id);

}
