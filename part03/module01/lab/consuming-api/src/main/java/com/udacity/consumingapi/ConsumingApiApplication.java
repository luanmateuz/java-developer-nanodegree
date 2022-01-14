package com.udacity.consumingapi;

import com.udacity.consumingapi.entity.Animechan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumingApiApplication {

	private static final Logger logger = LoggerFactory.getLogger(Animechan.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumingApiApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) {
		return args -> {
			Animechan animechan = restTemplate.getForObject(
					"https://animechan.vercel.app/api/random", Animechan.class);
			logger.info(animechan.toString());
		};
	}
}
