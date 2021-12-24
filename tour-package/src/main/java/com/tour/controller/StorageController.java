package com.tour.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.storage.*;
import com.tour.facade.Gcs;

@RestController
@RequestMapping("/gcs")
class StorageController {

	@GetMapping
	public String get(@RequestParam("file") MultipartFile file) throws FileNotFoundException, IOException, URISyntaxException {
		Gcs googleCloudStorage = new Gcs("src/main/resources/apt-footing-323918-bffa896f7493.json", "tour-package");

		// Bucket require globally unique names, so you'll probably need to change this
		Bucket bucket = googleCloudStorage.getBucket("western-bucket");

		return googleCloudStorage.uploadFile(file);

	}

}