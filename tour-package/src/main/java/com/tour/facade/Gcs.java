package com.tour.facade;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Acl.Role;
import com.google.cloud.storage.Acl.User;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Gcs {

	private Storage storage;

	private Bucket bucket;

	@Value("${file.storage}")
	private Resource localFilePath;

	private Credentials credentials;

	public Gcs(String pathToConfig, String projectId) throws FileNotFoundException, IOException, URISyntaxException {
		super();
		Resource resource = new ClassPathResource("apt-footing-323918-bffa896f7493.json");
		InputStream stream = resource.getInputStream();
		this.credentials = GoogleCredentials.fromStream(stream);
		this.storage = StorageOptions.newBuilder().setCredentials(credentials).setProjectId(projectId).build()
				.getService();
	}

	public Bucket getBucket(String bucketName) {
		bucket = storage.get(bucketName);
		if (bucket == null) {
			System.out.println("Creating new bucket.");
			bucket = storage.create(BucketInfo.of(bucketName));
		}
		return bucket;
	}

	public BlobId saveString(String blobName, String value, Bucket bucket) {
		byte[] bytes = value.getBytes(UTF_8);
		Blob blob = bucket.create(blobName, bytes);
		return blob.getBlobId();

	}

	public String uploadFile(MultipartFile file) throws IOException {
		DateTimeFormatter dtf = DateTimeFormat.forPattern("-YYYY-MM-dd-HHmmssSSS");
		DateTime dt = DateTime.now(DateTimeZone.UTC);
		String dtString = dt.toString(dtf);

		final String fileName = file.getOriginalFilename();

		BlobInfo blobInfo = storage.create(BlobInfo.newBuilder("western-bucket", fileName).build(),
				file.getInputStream());
		return blobInfo.getMediaLink();

	}

}
