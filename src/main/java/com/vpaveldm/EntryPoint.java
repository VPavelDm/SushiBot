package com.vpaveldm;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
@AllArgsConstructor
public class EntryPoint {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(EntryPoint.class, args);
    }
}
