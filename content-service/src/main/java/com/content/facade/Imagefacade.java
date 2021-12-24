package com.content.facade;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.content.service.BlogService;
import com.content.service.ImageService;
import com.content.service.ObjectMapperUtils;
import com.tourcoreservice.entity.Image;
import com.tourcoreservice.pojo.content.ImagePojo;

@Component
public class Imagefacade {
	@Autowired
	ImageService imageService;
	@Autowired
	BlogService blogService;

	public String upload(MultipartFile file) throws IOException {
		String encodedString = Base64.getEncoder().encodeToString(file.getBytes());
		Image image = new Image();
		image.setBase64(encodedString);
		image.setName(file.getName());
		image.setDescription("");
		image = imageService.upload(image);
		return "imageupload";

	}

	public String delete(long id) {
		// Blog blog=blogService.findById(id);
		Image image = imageService.getImageById(id);
		// blog.getImages().remove(image);
		imageService.delete(id);
		return null;
	}

	public List<ImagePojo> get() {
		ImagePojo imagePojo = new ImagePojo();
		List<Image> blogentity = imageService.getAll();
		List<ImagePojo> blogPojoList = ObjectMapperUtils.mapAll(blogentity, ImagePojo.class);
		return blogPojoList;
	}

}
