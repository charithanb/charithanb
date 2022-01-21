package com.account.accountservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.accountservice.facade.UserPasswordResetFacade;
import com.tourcoreservice.pojo.account.PasswordResetPojo;
import com.tourcoreservice.response.account.PasswordResetPojoListResponse;
import com.tourcoreservice.response.account.PasswordResetPojoResponse;

@RestController
@RequestMapping("/password-reset")
public class UserPasswordResetController {

	@Autowired
	UserPasswordResetFacade userPasswordResetFacade;

	@PostMapping
	public PasswordResetPojoResponse create(@RequestBody PasswordResetPojo passwordResetPojo) {
		return userPasswordResetFacade.createPasswordReset(passwordResetPojo);
	}

	@GetMapping
	public PasswordResetPojoListResponse getAllPasswordReset() {
		return userPasswordResetFacade.listAll();
	}

	@GetMapping("/{id}")
	public PasswordResetPojoResponse getPasswordResetById(@PathVariable Long id) {
		return userPasswordResetFacade.getPasswordResetByid(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		userPasswordResetFacade.delete(id);
	}

	@PutMapping()
	public PasswordResetPojoResponse resetPassword(@RequestBody PasswordResetPojo passwordResetPojo) {
		return userPasswordResetFacade.passwordReset(passwordResetPojo);

	}
}
