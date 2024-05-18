package com.itheima.proxy;

import java.lang.reflect.Method;

import com.itheima.service.UserService;
import com.itheima.service.UserServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

//代理处理器
public class CglibProxyHandler implements MethodInterceptor {

    //创建目标对象的代理对象
    public Object createProxy(Object target) {
        //创建CGLIB核心类实例
        Enhancer enhancer = new Enhancer();
        //设置需要增强的目标类（Class对象），目标类为代理对象的父类
        enhancer.setSuperclass(target.getClass());
        //设置回调对象，this代表本对象，程序执行目标方法时将会回调本对象的intercept()方法
        enhancer.setCallback(this);
        //创建代理对象并返回
        return enhancer.create();
    }

    //程序执行目标方法时被调用，在此增强目标方法功能
    //proxy CGLIB生成的代理对象
    //method 被拦截的方法
    //args 被拦截方法的参数数组
    //methodProxy 方法的代理对象，用于执行父类的方法
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("在此实现目标方法执行前增强");
        //通过方法代理对象执行目标方法（proxy的父类方法）
        Object obj = methodProxy.invokeSuper(proxy, args);
        System.out.println("在此实现目标方法执行后增强");
        //返回目标方法返回的结果
        return obj;
    }

    public static void main(String[] args) {
        CglibProxyHandler handler = new CglibProxyHandler();
        UserService userService = (UserService) handler.createProxy(new UserServiceImpl());
        System.out.println(userService.sayHello());
        System.out.println("-----------------");
        userService.sayHi();
    }
}
