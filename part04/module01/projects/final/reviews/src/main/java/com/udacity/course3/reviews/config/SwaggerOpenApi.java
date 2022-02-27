package com.udacity.course3.reviews.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerOpenApi {

    @Bean
    public OpenAPI springAppDoc() {
        return new OpenAPI()
                .info(new Info()
                        .title("Review API")
                        .description("Simple Rest API about Review, do in Udacity course!")
                        .version("0.0.1-SNAPSHOT")
                );
    }
}