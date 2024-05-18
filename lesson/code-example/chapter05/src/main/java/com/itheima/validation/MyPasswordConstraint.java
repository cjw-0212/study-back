package com.itheima.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 限定使用范围——只能在字段上使用
@Target({ElementType.FIELD})
// 表明注解的生命周期，它在代码运行时可以通过反射获取到注解
@Retention(RetentionPolicy.RUNTIME)
// validatedBy属性指定该注解的校验逻辑
@Constraint(validatedBy = MyPasswordValidator.class)
public @interface MyPasswordConstraint {
    // 定义错误提示
    String message() default "Invalid Password";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
