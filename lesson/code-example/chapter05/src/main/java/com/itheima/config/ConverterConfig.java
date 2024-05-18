package com.itheima.config;

import com.itheima.convert.DateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConverterConfig implements WebMvcConfigurer {
    @Autowired
    private DateFormatter myDateFormatter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(myDateFormatter);
    }

    @Override
    // 配置跨域路径映射
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("PUT,POST,GET,DELETE,OPTIONS")
                .allowedHeaders("*");
    }


}
