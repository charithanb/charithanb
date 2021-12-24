package com.account.accountservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.User;

@Repository
public interface CustomerRepository extends JpaRepository<User,Long>{
	
	User findById(long id);

	  
	@Query("SELECT u FROM User u WHERE type=:roleCustomer")
	List<User> findAllCustomers(@Param("roleCustomer") String roleCustomer);

}
