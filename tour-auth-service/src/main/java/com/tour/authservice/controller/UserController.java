package com.tour.authservice.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@GetMapping
	public List<String> get(){
		
		List<String> lists=  new ArrayList<>();
		lists.add("working");
		return lists;
		
	}

}
