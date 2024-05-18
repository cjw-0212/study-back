package com.scst.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RepeatableAnnotations {
	RepeatableAnnotation[] value();
}
