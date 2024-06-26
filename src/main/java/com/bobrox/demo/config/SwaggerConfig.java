package com.bobrox.demo.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customizeOpenApi() {

        return new OpenAPI()
                .info(new Info()
                        .title("School Management Application")
                        .version("1.1")
                        .description("Backend Application for managing a school")
                );

    }
}
