package com.moataz.springplaygrounds.SpringTut.validators;

import com.moataz.springplaygrounds.SpringTut.annotations.ValidateUser;
import com.moataz.springplaygrounds.SpringTut.dto.User;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator implements ConstraintValidator<ValidateUser, User> {
    //Check if the validator supports the given class
    @Override
    public void initialize(ValidateUser constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
        String regex = "^[\\w\\-\\.]+@([\\w-]+\\.)+[\\w-]{2,}$";

        Pattern pattern = Pattern.compile(regex);

        String email = user.getEmail();
        Matcher matcher = pattern.matcher(email);
        //Check if the matcher matches the email
        if (matcher.matches()) {
                return true;
        }
        return false;
    }
}
