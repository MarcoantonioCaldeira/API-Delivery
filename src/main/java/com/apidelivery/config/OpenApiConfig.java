package com.apidelivery.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI CustomApiConfig() {
        return new OpenAPI().info(infoAPI());
    }

    public Info infoAPI() {
        return new Info()
                .title("Restfull API")
                .description("API para Delivery")
                .license(
                        new License()
                                .name("Restfull API")
                                .url("http://ppwi4.bri.ifsp.edu.br")
                );
    }

}
