package com.example.shopproduct.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义请求源处理规则
 *
 * @author CJW
 * @since 2023/10/16
 */
@Component
public class MyRequestOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest request) {
        return request.getParameter("serviceName");
    }
}
