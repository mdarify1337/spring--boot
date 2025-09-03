package com.codewithmosh.store.repository;

import com.codewithmosh.store.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
