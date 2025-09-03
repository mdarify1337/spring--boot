package com.codewithmosh.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codewithmosh.store.models.User;
import com.codewithmosh.store.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUser(Long id) {
        return userRepo.findById(id).orElseThrow(() -> 
            new RuntimeException("User not found"));
    }

    public User updateUser(Long id, User updatedUser) {
        User user = getUser(id);
        user.setUsername(updatedUser.getUsername());
        user.setEmail(updatedUser.getEmail());
        return userRepo.save(user);
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
