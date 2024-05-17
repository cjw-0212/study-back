package com.example.springbootjwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web自定义配置类
 *
 * @author CJW
 * @since 2023/9/20
 */
@Configuration
public class  WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;

    /**
     * 注册拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginCheckInterceptor)
                //设置拦截全部请求但排除/user/login请求
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login");
    }
}
