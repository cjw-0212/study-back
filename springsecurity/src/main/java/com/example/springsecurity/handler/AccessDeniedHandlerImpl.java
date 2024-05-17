package com.example.springsecurity.handler;

import com.alibaba.fastjson.JSON;
import com.example.springsecurity.utils.Result;
import com.example.springsecurity.utils.WebUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
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
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        //处理异常
        Result result = new Result();
        result.setCode(HttpStatus.FORBIDDEN.value());
        result.setMessage("权限不足，无法访问");
        WebUtil.renderString(response, JSON.toJSONString(result));
    }
}
