package com.vpaveldm.database.repository;

import com.vpaveldm.database.model.Category;
import com.vpaveldm.database.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findAllByCategory(Category category);
    Optional<Ingredient> findByCategoryAndName(Category category, String name);
}
