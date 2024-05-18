package com.itheima.config;


import com.itheima.servletdev.MyFilter;
import com.itheima.servletdev.MyListener;
import com.itheima.servletdev.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ServletConfig {
    @Bean
    public ServletRegistrationBean servletRegistrationBean(MyServlet myServlet) {
        ServletRegistrationBean registrationBean =
                new ServletRegistrationBean(myServlet);
        registrationBean.setUrlMappings(Arrays.asList("/myServlet", "/jcServlet"));
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(MyFilter filter) {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(filter);
        registrationBean.setUrlPatterns(Arrays.asList("/myServlet", "/jcServlet"));
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(MyListener myListener) {
        ServletListenerRegistrationBean registrationBean =
                new ServletListenerRegistrationBean(myListener);
        return registrationBean;
    }

}

