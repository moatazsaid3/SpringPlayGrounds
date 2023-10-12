package com.moataz.springplaygrounds.SpringTut.annotations;

import com.moataz.springplaygrounds.SpringTut.validators.UserEmailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UserEmailValidator.class)
public @interface ValidateUserEmail {
    public String message() default "invalid user email: the format of the emial is incorrect";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
