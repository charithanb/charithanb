package com.content.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.content.service.BlogService;
import com.content.service.ObjectMapperUtils;
import com.tourcoreservice.pojo.content.BlogPojo;
import com.tourcoreservice.entity.Blog;

@Component
public class Blogfacade {
	@Autowired
	private BlogService blogService;

	public BlogPojo create(BlogPojo blogPojo) {
		Blog blog = ObjectMapperUtils.map(blogPojo, Blog.class);
		blog = blogService.create(blog);
		blogPojo = ObjectMapperUtils.map(blog, BlogPojo.class);
		return blogPojo;
	}

	public List<BlogPojo> get() {
		BlogPojo blogPojo = new BlogPojo();
		List<Blog> blogentity = blogService.getAll();
		List<BlogPojo> blogPojoList = ObjectMapperUtils.mapAll(blogentity, BlogPojo.class);
		return blogPojoList;
	}

	public BlogPojo update(BlogPojo blogPojo) {
		Blog blog = blogService.findById(blogPojo.getId());
		ObjectMapperUtils.map(blogPojo, blog);
		blogService.update(blog);
		return blogPojo;

	}

	public String delete(long id) {
		blogService.delete(id);
		return "Deleted Successfully";
	}

	public BlogPojo getbyid(long id) {
		Blog blog = blogService.findById(id);
		BlogPojo blogPojo = ObjectMapperUtils.map(blog, BlogPojo.class);
		return blogPojo;
	}

}
