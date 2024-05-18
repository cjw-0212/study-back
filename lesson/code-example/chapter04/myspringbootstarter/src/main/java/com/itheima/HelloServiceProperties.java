package com.itheima;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperties {
    //设置消息内容的默认值
    private String msg = "World";

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
