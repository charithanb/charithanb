package com.account.accountservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.accountservice.repository.UserRepository;
import com.tourcoreservice.entity.User;

@Service
public class UserService {

	@Autowired
	UserRepository userRespository;

	public User create(User user) {
		return userRespository.save(user);
	}

	public User getById(long id) {
		return userRespository.findById(id);
	}

	public List<User> listAll() {
		return userRespository.findAll();
	}

	public User Update(User user) {
		return userRespository.save(user);
	}

	public void delete(long id) {
		userRespository.deleteById(id);

	}

	public void save(User user) {
		userRespository.save(user);
	}

	public void deleteUsersRoles(User user) {
		user.getRoles().removeAll(user.getRoles());
		userRespository.save(user);
	}
	
	 public void processOAuthPostLogin(String username) {
	        User existUser = userRespository.getUserByUsername(username);
	         
	        if (existUser == null) {
	            User newUser = new User();
	            newUser.setUsername(username);         
	             
	            userRespository.save(newUser);        
	        }
	         
	    }

}
