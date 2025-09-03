package com.codewithmosh.store.models;

public class User {
    private int id;
    private String username;

    // Constructors
    public User() {}
    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
}
