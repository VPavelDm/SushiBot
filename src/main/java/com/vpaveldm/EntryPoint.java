package com.vpaveldm;

import com.vpaveldm.database.model.Category;
import com.vpaveldm.database.model.Ingredient;
import com.vpaveldm.database.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

import javax.annotation.PostConstruct;
import java.util.Arrays;
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
        Category sushi = Category.builder()
                .name("Суши")
                .build();
        List<Ingredient> ingredients = Arrays.asList(
                Ingredient
                        .builder()
                        .name("Лук")
                        .added(false)
                        .category(sushi)
                        .build(),
                Ingredient
                        .builder()
                        .name("Желток")
                        .added(false)
                        .category(sushi)
                        .build()
        );
        sushi.setIngredients(ingredients);

        Category dessert = Category.builder()
                .name("Дессерты")
                .build();
        List<Ingredient> dessertIngredients = Arrays.asList(
                Ingredient.builder()
                        .name("Сахар")
                        .category(dessert)
                        .added(false)
                        .build(),
                Ingredient.builder()
                        .name("Белок")
                        .added(false)
                        .category(dessert)
                        .build()
        );
        dessert.setIngredients(dessertIngredients);
        categoryRepository.saveAll(Arrays.asList(sushi, dessert));
    }
}
