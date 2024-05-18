package com.itheima.proxy;

import com.itheima.service.UserService;
import com.itheima.service.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//代理处理器
public class JdkProxyHandler implements InvocationHandler {
    //声明目标对象
    private Object target;

    //创建目标对象的代理对象
    public Object createProxy(Object target) {
        this.target = target;
        //获取目标类（Class对象）
        Class<?> clazz = target.getClass();
        //获取目标类的类加载器
        ClassLoader classLoader = clazz.getClassLoader();
        //获取目标类实现的所有接口
        Class<?>[] interfaces = clazz.getInterfaces();
        //创建代理对象并返回
        return Proxy.newProxyInstance(classLoader, interfaces, this);
    }

    //程序执行目标方法时被调用，在此增强目标方法功能
    //proxy JDK生成的代理对象
    //method 被反射的方法
    //args 被反射方法的参数数组
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("在此实现目标方法执行前增强");
        //执行目标方法
        Object obj = method.invoke(target, args);
        System.out.println("在此实现目标方法执行后增强");
        //返回目标方法返回的结果
        return obj;
    }

    public static void main(String[] args) {
        JdkProxyHandler handler = new JdkProxyHandler();
        UserService userService = (UserService) handler.createProxy(new UserServiceImpl());
        System.out.println(userService.sayHello());
        System.out.println("-----------------");
        userService.sayHi();
    }
}
