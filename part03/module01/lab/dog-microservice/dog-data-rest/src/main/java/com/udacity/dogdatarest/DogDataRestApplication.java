package com.udacity.dogdatarest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DogDataRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogDataRestApplication.class, args);
	}

}
