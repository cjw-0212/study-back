package com.itheima.controller;

import com.itheima.config.DBConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DBController {
    @Autowired
    private DBConnector dbConnector;

    @GetMapping("/showDB")
    public void showDB() {
        dbConnector.configure();
    }
}

