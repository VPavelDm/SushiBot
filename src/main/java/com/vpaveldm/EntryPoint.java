package com.vpaveldm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class EntryPoint {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(EntryPoint.class, args);
    }
}
