package com.tourcoreservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TourCoreserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourCoreserviceApplication.class, args);
	}

}
