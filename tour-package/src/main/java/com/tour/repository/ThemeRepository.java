package com.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.Theme;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {
	Theme findById(long id);
}
