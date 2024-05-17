package com.example.shoporder.services;

import com.example.shopcommon.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author CJW
 * @since 2023/10/16
 */
@FeignClient("service-user")
public interface UserService {
    @GetMapping("/user/{userId}")
    User getOne(@PathVariable("userId") Integer userId);
}
