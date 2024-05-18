package com.scst.service;

//目标类
public class UserServiceImpl implements UserService {
    private String hello = "hello";

    public void sayHi() {
        System.out.println("hi");
    }

    public String sayHello() {
        System.out.println(this.hello);
        return this.hello;
    }
}
