package com.moataz.springplaygrounds.SpringTut.annotations;

import com.moataz.springplaygrounds.SpringTut.validators.UserValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UserValidator.class)
public @interface ValidateUser {

    String message() default "invalid input";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
