package com.events.westernevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com.tourcoreservice.entity")
@SpringBootApplication
public class WesternEventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WesternEventsApplication.class, args);
	}

}
