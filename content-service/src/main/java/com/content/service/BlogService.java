package com.content.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.content.repository.BlogRepository;
import com.tourcoreservice.entity.Blog;

@Service
public class BlogService {
	@Autowired
	private BlogRepository blogRepository;

	public Blog create(Blog blog) {
		return blogRepository.save(blog);
	}

	public List<Blog> getAll() {
		return blogRepository.findAll();
	}

	public Blog findById(long id) {
		return blogRepository.findById(id);
	}

	public Blog update(Blog blogEntity) {
		return blogRepository.save(blogEntity);
	}

	public void delete(long id) {
		blogRepository.deleteById(id);
	}

}
