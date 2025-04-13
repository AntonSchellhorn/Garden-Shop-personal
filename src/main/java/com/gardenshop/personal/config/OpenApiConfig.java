package com.gardenshop.personal.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("GardenShop Personal API")
                        .version("1.0")
                        .description("Документация к REST API дипломного проекта GardenShop")
                        .contact(new Contact()
                                .name("Антон Шелльхорн")
                                .email("anton@example.com")
                        )
                );
    }
}
