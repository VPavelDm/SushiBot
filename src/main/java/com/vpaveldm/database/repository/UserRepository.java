package com.vpaveldm.database.repository;

import com.vpaveldm.database.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByTelegramId(Long telegramId);
}
