package com.itheima.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 限定使用范围——可在字段、类、注解上使用
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
// 表明注解的生命周期，它在代码运行时可以通过反射获取到注解
@Retention(RetentionPolicy.RUNTIME)
// validatedBy属性指定该注解的校验逻辑
@Constraint(validatedBy = PasswordMatchValidator.class)
public @interface PasswordMatchConstraint {
    String message() default "Password Not Match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
