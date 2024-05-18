package com.scst.controller;

import com.scst.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/reduce/{id}")
    public String reduce(@PathVariable("id") String accountId) {
        boolean flag = accountService.reduce(accountId);
        return "账号："+accountId+"，扣款成功!";
    }
}