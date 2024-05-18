package com.itheima;

public class HelloService {

    private String msg;

    public String haloHello() {
        return "Hello Starter ===============>>>>" + msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ;
}
