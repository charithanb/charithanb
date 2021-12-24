package com.content.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.content.repository.ImageRepository;
import com.tourcoreservice.entity.Image;

@Service
public class ImageService {
	@Autowired
	private ImageRepository imageRepository;

	public Image upload(Image image) {
		return imageRepository.save(image);

	}

	public void delete(long id) {
		imageRepository.deleteById(id);
	}

	public List<Image> getAll() {

		return imageRepository.findAll();

	}

	public Image getImageById(long id) {
		return imageRepository.findById(id);
	}

}
