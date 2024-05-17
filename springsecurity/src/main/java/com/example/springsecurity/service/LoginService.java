package com.example.springsecurity.service;

import com.example.springsecurity.pojo.User;
import com.example.springsecurity.utils.Result;

/**
 * @author CJW
 * @since 2023/10/25
 */
public interface LoginService {

    Result<String> login(User user);

    Result<String> logout();
}
