package com.tour;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.atomic.LongAdder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.tour.facade.Gcs;

@SpringBootApplication
@ComponentScan(basePackages="com.tour")
@EntityScan(basePackages = "com.tourcoreservice.entity")
@EnableDiscoveryClient
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled=true,securedEnabled=true)
public class TourPackageApplication {

	public static void main(String[] args) throws FileNotFoundException, IOException, URISyntaxException {
		SpringApplication.run(TourPackageApplication.class, args);
		Gcs googleCloudStorage = new Gcs("test", "tour-package");
		LongAdder ls=new LongAdder();

	}

}
