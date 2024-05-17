package com.example.springsecurity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.springsecurity.mapper.UserMapper;
import com.example.springsecurity.pojo.LoginUser;
import com.example.springsecurity.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author CJW
 * @since 2023/10/25
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询用户信息
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserName, username);
        User user = userMapper.selectOne(wrapper);
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户名或者密码错误");
        }
        //TODO 查询对应的权限信息
        List<String> authorities = new ArrayList<>(Arrays.asList("test", "admin"));
        return new LoginUser(user, authorities);
    }
}
