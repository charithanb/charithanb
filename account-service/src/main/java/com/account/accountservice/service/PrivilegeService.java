package com.account.accountservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.account.accountservice.repository.PrivilegeRepository;
import com.tourcoreservice.entity.Privilege;

@Service
public class PrivilegeService {
	
	@Autowired
	PrivilegeRepository privilegeRepository;

	public Privilege create(Privilege privilege) {
		return privilegeRepository.save(privilege);
	}

	public List<Privilege> getAll() {
		return privilegeRepository.findAll();
	}

	public Privilege findPrivilegeById(long id) {
		return privilegeRepository.findById(id);
	}

	public Privilege update(Privilege privilege) {
		return privilegeRepository.saveAndFlush(privilege);
	}

	public void delete(Privilege privilege) {
		privilegeRepository.delete(privilege);
	}

}
