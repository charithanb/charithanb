package com.account.accountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	User findById(long id);

	User getUserByUsername(String username);

	

}
