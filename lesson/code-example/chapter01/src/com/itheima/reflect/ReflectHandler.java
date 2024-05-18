package com.itheima.reflect;

import com.itheima.service.UserService;
import com.itheima.service.UserServiceImpl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

//反射处理器类
public class ReflectHandler {

    //运行时获取目标对象的类信息（方法和属性）
    public void getMethodsandFields(Object target) throws Exception {
        //获取目标类（Class对象）
        Class<?> clazz = target.getClass();
        //获取目标类的所有方法并调用
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m);
            m.invoke(target, null);
        }
        //获取目标类的所有属性
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f);
        }
    }

    //运行时改变目标对象私有变量的值
    public void setField(Object target, String fieldName, Object value) throws Exception {
        //获取目标类（Class对象）
        Class<?> clazz = target.getClass();
        //获取目标类的指定字段并修改其值
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    public static void main(String[] args) throws Exception {
        UserService userService = new UserServiceImpl();
        userService.sayHello();
        ReflectHandler handler = new ReflectHandler();
        handler.setField(userService, "hello", "Hello World");
        userService.sayHello();
        handler.getMethodsandFields(userService);
    }
}
