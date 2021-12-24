package com.content.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.content.facade.Imagefacade;
import com.tourcoreservice.pojo.content.ImagePojo;

@RequestMapping("/image")
@RestController
public class ImageController {
	@Autowired
	private Imagefacade imagefacade;

	@GetMapping("/findAll")
	public List<ImagePojo> get() {
		return imagefacade.get();

	}

	@PostMapping("/Imageupload")
	public String submit(@RequestBody MultipartFile file) throws IOException {
		imagefacade.upload(file);
		return "fileUploadView";

	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") long id) {
		return imagefacade.delete(id);

	}

}
