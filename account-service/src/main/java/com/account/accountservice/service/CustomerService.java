package com.account.accountservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.accountservice.repository.CustomerRepository;
import com.tourcoreservice.entity.Customer;
import com.tourcoreservice.entity.User;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRespository;

	public Customer create(Customer customer) {
		return customerRespository.save(customer);
	}

	public List<User> findAllCustomers(String roleCustomer) {
		return customerRespository.findAllCustomers(roleCustomer);
	}

	public User findById(long id) {

		return customerRespository.findById(id);
	}

	public User update(User userEntity) {
		return customerRespository.save(userEntity);
	}

	public void delete(User userEntity) {

		customerRespository.delete(userEntity);
	}

	public void save(User user) {
		customerRespository.save(user);

	}

}
