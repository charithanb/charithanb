package com.tour.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourcoreservice.entity.User;


public interface UserRepository extends JpaRepository<User, String> {
	User findByUsername(String username);


}
