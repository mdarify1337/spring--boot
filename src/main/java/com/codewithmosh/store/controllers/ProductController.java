package com.codewithmosh.store.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codewithmosh.store.models.Product;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final Map<Integer, Product> products = new HashMap<>();

    // CREATE
    @PostMapping
    public String createProduct(@RequestParam String name) {
        int id = products.size() + 1;
        products.put(id, new Product(id, name));
        return "Product created with id " + id;
    }

    // READ all
    @GetMapping
    public Collection<Product> getAllProducts() {
        return products.values();
    }

    // READ one
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id) {
        return products.getOrDefault(id, new Product(0, "Product not found"));
    }

    // UPDATE
    @PutMapping("/{id}")
    public String updateProduct(@PathVariable int id, @RequestParam String name) {
        if (products.containsKey(id)) {
            products.put(id, new Product(id, name));
            return "Product updated";
        }
        return "Product not found";
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        if (products.containsKey(id)) {
            products.remove(id);
            return "Product deleted";
        }
        return "Product not found";
    }
}
