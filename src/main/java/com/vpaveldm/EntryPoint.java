package com.vpaveldm;

import com.vpaveldm.database.model.Category;
import com.vpaveldm.database.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class EntryPoint {

    private final CategoryRepository categoryRepository;

    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(EntryPoint.class, args);
    }

    @PostConstruct
    void init() {
        categoryRepository.saveAll(List.of(
                Category.builder()
                        .name("Суши")
                        .build(),
                Category.builder()
                        .name("Дессерты")
                        .build()
        ));
    }
}
