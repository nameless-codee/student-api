package com.niru.student_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // GET request using an API endpoint "api/hello"
    // @GetMapping used to map HTTP GET requests onto specific handler methods
    @GetMapping("/api/hello")
    public String hello() {
        return "Hello Spring Boot 👋";
    }
}