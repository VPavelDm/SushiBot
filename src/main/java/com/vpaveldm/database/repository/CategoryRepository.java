package com.vpaveldm.database.repository;

import com.vpaveldm.database.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByName(String name);
    Optional<Category> findByName(String name);
}
