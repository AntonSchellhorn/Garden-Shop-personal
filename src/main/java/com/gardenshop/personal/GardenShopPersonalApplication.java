package com.gardenshop.personal;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@OpenAPIDefinition(
        info = @Info(
                title = "GardenShop Personal API",
                version = "1.0",
                description = "Документация к REST API дипломного проекта GardenShop.",
                contact = @Contact(name = "Антон", email = "anton@example.com")
        )
)
public class GardenShopPersonalApplication {

    public static void main(String[] args) {
        SpringApplication.run(GardenShopPersonalApplication.class, args);
    }
}
