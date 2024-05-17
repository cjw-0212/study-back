package com.example.validation.controller;


import com.example.validation.pojo.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author CJW
 * @since 2023/11/21
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @PostMapping
    public String post(@Valid @RequestBody Student student) {
        System.out.println(student);
        return "success";
    }
}
