package com.moataz.springplaygrounds.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // annotation will be available at runtime
@Target(ElementType.METHOD) // annotation can be applied to methods
public @interface helloWorld {
    String value() default "Hello"; // parameter with default value
    int number(); // parameter with no default value
}
