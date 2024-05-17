package com.example.springsecurity.handler;

import com.alibaba.fastjson.JSON;
import com.example.springsecurity.utils.Result;
import com.example.springsecurity.utils.WebUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CJW
 * @since 2023/10/27
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
        //处理异常
        Result result = new Result();
        result.setCode(HttpStatus.UNAUTHORIZED.value());
        result.setMessage("用户认证失败，请重新登录");
        WebUtil.renderString(response, JSON.toJSONString(result));
    }
}
