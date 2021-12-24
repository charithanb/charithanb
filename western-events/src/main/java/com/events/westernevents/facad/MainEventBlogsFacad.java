package com.events.westernevents.facad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.events.westernevents.service.MainEventBlogsService;
import com.tourcoreservice.entity.events.MainEventBlogs;
import com.tourcoreservice.pojo.events.MainEventBlogsPojo;
import com.tourcoreservice.response.events.MainEventBloglistResponse;
import com.tourcoreservice.response.events.MainEventBlogsResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class MainEventBlogsFacad {

	@Autowired
	MainEventBlogsService mEventBlogsService;
	
	public MainEventBloglistResponse listAllBlogs() {
		MainEventBloglistResponse mEventBloglistResponse = new MainEventBloglistResponse();
		List<MainEventBlogs> mEventBlogs = mEventBlogsService.listAll();
		List<MainEventBlogsPojo> mEventPubsPojos = ObjectMapperUtils.mapAll(mEventBlogs, MainEventBlogsPojo.class);
		mEventBloglistResponse.setmBlogsPojos(mEventPubsPojos);
		return mEventBloglistResponse;
	}
	
	public MainEventBlogsResponse getBlog(long id) {
		MainEventBlogsResponse mEventBlogsResponse = new MainEventBlogsResponse();
		MainEventBlogs mEventBlogs = mEventBlogsService.getById(id);
		MainEventBlogsPojo mEventBlogsPojo = ObjectMapperUtils.map(mEventBlogs,MainEventBlogsPojo.class);
		mEventBlogsResponse.setmEventBlogsPojo(mEventBlogsPojo);
		return mEventBlogsResponse;
	}

	public MainEventBlogsResponse saveBlog(MainEventBlogsPojo blogsPojo) {
		MainEventBlogsResponse mEventBlogsResponse = new MainEventBlogsResponse();
		MainEventBlogs mEventBlogs = ObjectMapperUtils.map(blogsPojo, MainEventBlogs.class);
		MainEventBlogs mEventBlogs2 = mEventBlogsService.create(mEventBlogs);
		MainEventBlogsPojo mEventBlogsPojo = ObjectMapperUtils.map(mEventBlogs2,MainEventBlogsPojo.class);
		mEventBlogsResponse.setmEventBlogsPojo(mEventBlogsPojo);
		return mEventBlogsResponse;
	}

	public MainEventBlogsResponse updateBlog(MainEventBlogsPojo blogsPojo) {
		MainEventBlogsResponse mEventBlogsResponse = new MainEventBlogsResponse();
		MainEventBlogs mEventBlogs = ObjectMapperUtils.map(blogsPojo, MainEventBlogs.class);
		MainEventBlogs mEventBlogs2 = mEventBlogsService.Update(mEventBlogs);
		MainEventBlogsPojo mEventBlogsPojo = ObjectMapperUtils.map(mEventBlogs2,MainEventBlogsPojo.class);
		mEventBlogsResponse.setmEventBlogsPojo(mEventBlogsPojo);
		return mEventBlogsResponse;
	}

	public void delete(long id) {
		
		mEventBlogsService.delete(id);
	}
}
