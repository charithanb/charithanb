package com.events.westernevents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.events.westernevents.repository.MainEventBlogsRepository;
import com.tourcoreservice.entity.events.MainEventBlogs;

@Service
public class MainEventBlogsService {

	@Autowired
	private MainEventBlogsRepository mEventBlogsRepository;
	
	public MainEventBlogs create(MainEventBlogs mBlogs) {
		return mEventBlogsRepository.save(mBlogs);
	}

	public MainEventBlogs getById(long id) {
		return mEventBlogsRepository.findById(id).get();
	}

	public List<MainEventBlogs> listAll() {
		return mEventBlogsRepository.findAll();
	}

	public void delete(long id) {
		mEventBlogsRepository.deleteById(id);

	}

	public MainEventBlogs Update(MainEventBlogs mEventBlogs) {
		return mEventBlogsRepository.save(mEventBlogs);
	}

}
