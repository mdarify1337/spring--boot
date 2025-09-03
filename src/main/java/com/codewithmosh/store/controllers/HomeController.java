package com.codewithmosh.store.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/about")
    public String about() {
        return "You are in about page ??? ";
    }

    @RequestMapping("/")
    public String index() {
        return "Welcome to the home page! This is a change for devtools";
    }
}
