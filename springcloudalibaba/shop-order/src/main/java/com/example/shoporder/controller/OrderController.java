package com.example.shoporder.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.shopcommon.pojo.Order;
import com.example.shopcommon.pojo.Product;
import com.example.shopcommon.pojo.User;
import com.example.shoporder.services.ProductService;
import com.example.shoporder.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author CJW
 * @since 2023/10/16
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private UserService userService;
    @Resource
    private ProductService productService;

    @GetMapping("/{userId}/{productId}")
    public Order getOne(@PathVariable("userId") Integer userId, @PathVariable("productId") Integer productId) {
        User user = userService.getOne(userId);
        Product product = productService.getOne(productId);
        Order order = new Order();
        order.setOid(1);
        order.setUser(user);
        order.setProduct(product);
        /*//模拟网络延时
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        return order;
    }

    @GetMapping("/msg1")
    public String getMessage1() {
        return "msg1";
    }

    @GetMapping("/msg2")
    public String getMessage2() {
        return "msg2";
    }

    //sentinel异常比实验
    int i = 0;

    @GetMapping("/msg3")
    public String getMessage3() {
        i++;
        if (i % 3 == 0) {
            throw new RuntimeException();
        }
        return "msg3";
    }

    //热点规则测试
    @SentinelResource("hot")
    @GetMapping("/hot")
    public String hot(String name, Integer age) {
        return name + age;
    }
}
