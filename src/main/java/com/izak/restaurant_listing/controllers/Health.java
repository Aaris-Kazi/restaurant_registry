package com.izak.restaurant_listing.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Health {
    @GetMapping("health")
    public String health() {
        return "OK";
    }
}

