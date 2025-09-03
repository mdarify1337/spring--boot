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

import com.codewithmosh.store.models.User;

@RestController
@RequestMapping("/users")
public class UserController {

    private final Map<Integer, User> users = new HashMap<>();

    // CREATE
    @PostMapping
    public String createUser(@RequestParam String username) {
        int id = users.size() + 1;
        users.put(id, new User(id, username));
        return "User created with id " + id;
    }

    // READ all
    @GetMapping
    public Collection<User> getAllUsers() {
        return users.values();
    }

    // READ one
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return users.getOrDefault(id, new User(0, "User not found"));
    }

    // UPDATE
    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id, @RequestParam String username) {
        if (users.containsKey(id)) {
            users.put(id, new User(id, username));
            return "User updated";
        }
        return "User not found";
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        if (users.containsKey(id)) {
            users.remove(id);
            return "User deleted";
        }
        return "User not found";
    }
}
