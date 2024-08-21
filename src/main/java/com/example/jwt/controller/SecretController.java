package com.example.jwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secret")
public class SecretController {

    @GetMapping("/get-secret")
    public ResponseEntity<String> getSecret(){
        return ResponseEntity.ok("Welcome to secret route");
    }
}
