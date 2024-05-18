package com.scst.controller;

import com.scst.domain.Order;
import com.scst.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/successes")
    public String successes() {
        return orderService.secKillSuccesses();
    }

    @GetMapping("/orders")
    public List<Order> orders() {
        return orderService.getOrders();
    }
}