package com.vpaveldm.database.repository;

import com.vpaveldm.database.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {
}
