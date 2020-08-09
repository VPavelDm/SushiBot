package com.vpaveldm.database.repository;

import com.vpaveldm.database.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
