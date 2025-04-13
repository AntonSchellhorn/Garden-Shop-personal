package com.gardenshop.personal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling; // ← ВАЖНО

@SpringBootApplication
@EnableScheduling // ← ДОБАВЬ ЭТУ СТРОКУ
public class GardenShopPersonalApplication {

    public static void main(String[] args) {
        SpringApplication.run(GardenShopPersonalApplication.class, args);
    }
}
