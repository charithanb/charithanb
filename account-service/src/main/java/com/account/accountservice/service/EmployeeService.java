package com.account.accountservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.accountservice.repository.EmployeeRepository;
import com.tourcoreservice.entity.Employee;
import com.tourcoreservice.entity.User;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public Employee create(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<User> findAllEmployees(String roleEmployee) {
		return employeeRepository.findEmployees(roleEmployee);
	}

	public User findById(long id) {
		return employeeRepository.findById(id);
	}

	public User update(User user) {
		return employeeRepository.save(user);
	}

	public void delete(User user) {
		employeeRepository.delete(user);

	}

	public void save(User user) {
		employeeRepository.save(user);
		
	}

}
