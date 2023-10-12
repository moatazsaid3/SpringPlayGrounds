package com.moataz.springplaygrounds.SpringTut.validators;

import com.moataz.springplaygrounds.SpringTut.annotations.ValidateUserEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserEmailValidator implements ConstraintValidator<ValidateUserEmail, String> {


    @Override
    public void initialize(ValidateUserEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        String regex = "^[\\w\\-\\.]+@([\\w-]+\\.)+[\\w-]{2,}$";

        Pattern pattern = Pattern.compile(regex);


        Matcher matcher = pattern.matcher(s);

        //Check if the matcher matches the email
        if (!matcher.matches()) {
            throw new RuntimeException();
        }
        return true;
    }
}
