package com.scst.annotation;


import java.lang.annotation.Repeatable;

@Repeatable(RepeatableAnnotations.class)
public @interface RepeatableAnnotation {
	int a() default 0;
	int b() default 0;
	int c() default 0;
}
