package com.vpaveldm.database.repository;

import com.vpaveldm.database.model.Category;
import com.vpaveldm.database.model.Ingredient;
import com.vpaveldm.database.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Set<Item> findByCategoryAndIngredientsIn(Category category, Set<Ingredient> ingredients);
    Set<Item> findByCategory(Category category);
}
