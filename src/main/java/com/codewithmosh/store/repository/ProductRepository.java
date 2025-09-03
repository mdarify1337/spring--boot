package com.codewithmosh.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithmosh.store.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {}
