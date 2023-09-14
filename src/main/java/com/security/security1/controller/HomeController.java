package com.security.security1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    String home() {
        return "Hello Security!";
    }

    @GetMapping("/login")
    String login() {
        return "Bejelntekő oldal";
    }
}
