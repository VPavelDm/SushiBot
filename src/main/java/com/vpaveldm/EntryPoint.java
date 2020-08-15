package com.vpaveldm;

import com.vpaveldm.database.model.Category;
import com.vpaveldm.database.model.Ingredient;
import com.vpaveldm.database.model.Item;
import com.vpaveldm.database.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
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
                        .category(sushi)
                        .build(),
                Ingredient
                        .builder()
                        .name("Желток")
                        .category(sushi)
                        .build()
        );
        List<Item> items = Arrays.asList(
                Item.builder()
                        .name("Суши 1")
                        .description("Очень вкусные суши")
                        .photoURL("src/main/resources/takeshi_maki.jpg")
                        .price(2.45)
                        .category(sushi)
                        .ingredients(Collections.singleton(ingredients.get(0)))
                        .date(new Date())
                        .build(),
                Item.builder()
                        .name("Суши 2")
                        .description("Не очень вкусные суши")
                        .photoURL("src/main/resources/fruto_maki.jpg")
                        .price(1.35)
                        .category(sushi)
                        .ingredients(Collections.singleton(ingredients.get(1)))
                        .date(new Date(121212L))
                        .build()
        );
        sushi.setIngredients(ingredients);
        sushi.setItems(items);

        Category dessert = Category.builder()
                .name("Дессерты")
                .build();
        List<Ingredient> dessertIngredients = Arrays.asList(
                Ingredient.builder()
                        .name("Сахар")
                        .category(dessert)
                        .build(),
                Ingredient.builder()
                        .name("Белок")
                        .category(dessert)
                        .build()
        );
        dessert.setIngredients(dessertIngredients);
        categoryRepository.saveAll(Arrays.asList(sushi, dessert));
    }
}
