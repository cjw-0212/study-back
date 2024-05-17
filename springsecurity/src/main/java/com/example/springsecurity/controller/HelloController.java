package com.example.springsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CJW
 * @since 2023/10/25
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    @PreAuthorize("hasAuthority('test')")
    public String hello() {
        return "Hello";
    }
}
