package com.events.westernevents.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.events.westernevents.facad.MainEventBlogsFacad;
import com.tourcoreservice.pojo.events.MainEventBlogsPojo;
import com.tourcoreservice.response.events.MainEventBloglistResponse;
import com.tourcoreservice.response.events.MainEventBlogsResponse;


@RestController
@RequestMapping("/MainEventBlogs")
public class MainEventBlogsController {

	@Autowired
	MainEventBlogsFacad mEventBlogsFacad;

	@GetMapping
	public MainEventBloglistResponse getAll() {
		return mEventBlogsFacad.listAllBlogs();
	}

	@GetMapping("/{id}")
	public MainEventBlogsResponse get(@PathVariable long id) {
		return mEventBlogsFacad.getBlog(id);
	}

	@PostMapping
	public MainEventBlogsResponse create(@RequestBody MainEventBlogsPojo blogsPojo) {
		return mEventBlogsFacad.saveBlog(blogsPojo);
	}

	@PutMapping("/{id}")
	public MainEventBlogsResponse update(@RequestBody MainEventBlogsPojo blogsPojo, @PathVariable long id) {
		blogsPojo.setId(id);
		return mEventBlogsFacad.updateBlog(blogsPojo);

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		mEventBlogsFacad.delete(id);
	}
}
