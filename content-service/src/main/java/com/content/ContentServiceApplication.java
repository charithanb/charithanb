package com.content;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.content.entity")
public class ContentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentServiceApplication.class, args);
	}
}
