package com.account.accountservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.accountservice.repository.RoleRepository;
import com.tourcoreservice.entity.Role;

@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepository;

	public Role create(Role role) {
		return roleRepository.saveAndFlush(role);
	}

	public List<Role> findAllRoles() {

		return roleRepository.findAll();
	}

	public Role findRoleById(long id) {
		
		return roleRepository.findById(id);
	}

	public Role update(Role role) {
		return roleRepository.saveAndFlush(role);
	}

	public void delete(Role role) {
		roleRepository.delete(role);
	}

	public void save(Role role) {
		roleRepository.save(role);
		
	}

	public List<Role> findParentRole() {
		return roleRepository.findAll();
	}

	public List<Role> findEmployeeRoles() {
		return roleRepository.findAll();
	}

	public List<Role> findCustomerRoles() {
		return roleRepository.findAll();
	}
}
