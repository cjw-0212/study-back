package com.example.springsecurity.service.impl;

import com.example.springsecurity.pojo.LoginUser;
import com.example.springsecurity.pojo.User;
import com.example.springsecurity.service.LoginService;
import com.example.springsecurity.utils.JwtUtils;
import com.example.springsecurity.utils.RedisCache;
import com.example.springsecurity.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author CJW
 * @since 2023/10/25
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;

    @Override
    public Result<String> login(User user) {
        //使用authenticationManager进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken
                (user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authenticate)) {
            //为空认证失败
            throw new RuntimeException("登陆失败");
        }
        //认证成功，使用userId生成jwt
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtils.createJwt(userId);
        //完整的用户信息存入redis
        redisCache.setCacheObject("login:" + userId, loginUser);
        return Result.success(jwt);
    }

    @Override
    public Result<String> logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userid = loginUser.getUser().getId();
        redisCache.deleteObject("login:" + userid);
        return Result.success("退出成功");
    }
}
