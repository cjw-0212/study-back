package com.itheima.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//声明一个切面类，并作为一个组件使用时才有效
@Aspect
@Component
public class MyAspect {
    // 定义切入点，通知增强目标类中的哪些方法
    @Pointcut("execution(* com.itheima.aspectj.*.*(..))")
    private void myPointCut() {
    }

    // 前置通知，使用JoinPoint接口作为参数获得目标对象信息
    @Before("myPointCut()")
    public void myBefore(JoinPoint joinPoint) {
        System.out.print("前置通知 ：模拟执行权限检查...,");
        System.out.print("目标类是：" + joinPoint.getTarget());
        System.out.println(",被织入增强处理的目标方法为：" + joinPoint.getSignature().getName());
    }

    // 环绕通知
    @Around("myPointCut()")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 开始
        System.out.println("环绕开始：执行目标方法之前，模拟开启事务...");
        // 执行当前目标方法
        Object obj = proceedingJoinPoint.proceed();
        // 结束
        System.out.println("环绕结束：执行目标方法之后，模拟关闭事务...");
        return obj;
    }

    // 异常通知
    @AfterThrowing(value = "myPointCut()", throwing = "e")
    public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
        System.out.println("异常通知：" + "出错了" + e.getMessage());
    }

    // 最终通知
    @After("myPointCut()")
    public void myAfter() {
        System.out.println("最终通知：模拟方法结束后的释放资源...");
    }

    // 后置通知
    @AfterReturning(value = "myPointCut()")
    public void myAfterReturning(JoinPoint joinPoint) {
        System.out.print("后置通知：模拟记录日志...,");
        System.out.println("被织入增强处理的目标方法为：" + joinPoint.getSignature().getName());
    }
}
