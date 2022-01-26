package com.udacity.vehicles.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerOpenApi {

    @Bean
    public OpenAPI springAppDoc() {
        return new OpenAPI().info(
                new Info()
                        .title("Vehicles API")
                        .description("Simple Rest API about Vehicles, taken during the Udacity course")
                        .version("0.0.1-SNAPSHOT")
                        .license(new License()
                                .name("MIT License").url("https://opensource.org/licenses/MIT")))
                .externalDocs(
                        new ExternalDocumentation()
                                .description("Vehicles API Documentation")
                                .url("https://github.com/luanmateuz/java-developer-nanodegree/tree/main/part03/module01/project"));
    }
}