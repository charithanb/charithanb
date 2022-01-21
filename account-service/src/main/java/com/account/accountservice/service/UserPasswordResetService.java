package com.account.accountservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.accountservice.repository.UserPasswordResetRepository;
import com.tourcoreservice.entity.UserPasswordReset;

@Service
public class UserPasswordResetService {

	@Autowired
	UserPasswordResetRepository userPasswordResetRepository;

	public UserPasswordReset updatePasswardById(UserPasswordReset passwordReset) {
		return userPasswordResetRepository.save(passwordReset);
	}

	public UserPasswordReset create(UserPasswordReset userPasswordReset) {
		return userPasswordResetRepository.save(userPasswordReset);
	}

	public List<UserPasswordReset> findAll() {
		return userPasswordResetRepository.findAll();
	}

	public UserPasswordReset findPasswordById(Long id) {
		return userPasswordResetRepository.findById(id).get();
	}

	public void deletePasswordById(long id) {
		userPasswordResetRepository.deleteById(id);
	}
}
