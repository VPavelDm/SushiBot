package com.vpaveldm.database.repository;

import com.vpaveldm.database.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
