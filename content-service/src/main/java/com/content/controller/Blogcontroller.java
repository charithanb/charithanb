package com.content.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.content.facade.Blogfacade;
import com.tourcoreservice.pojo.content.BlogPojo;


@RestController
@RequestMapping("/blog")
public class Blogcontroller {
	@Autowired
	private Blogfacade blogfacade;

	@PostMapping("/create")
	public BlogPojo create(@RequestBody BlogPojo blogPojo) {
		return blogfacade.create(blogPojo);

	}

	@GetMapping("/findAll")
	public List<BlogPojo> get() {
		return blogfacade.get();

	}

	@PutMapping("/update")
	public BlogPojo update(@RequestBody BlogPojo blogPojo) {
		return blogfacade.update(blogPojo);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") long id) {
		return blogfacade.delete(id);

	}

	@GetMapping("/findimagebyblogid/{id}")
	public BlogPojo findbyblogid(@PathVariable("id") long id) {

		return blogfacade.getbyid(id);

	}

}
