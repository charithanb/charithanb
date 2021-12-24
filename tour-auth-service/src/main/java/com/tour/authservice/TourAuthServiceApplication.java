package com.tour.authservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EntityScan(basePackages = "com.tourcoreservice.entity")
public class TourAuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourAuthServiceApplication.class, args);
	}

}
