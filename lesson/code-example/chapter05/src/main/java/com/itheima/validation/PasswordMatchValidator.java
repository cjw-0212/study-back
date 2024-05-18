package com.itheima.validation;

import com.itheima.domain.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatchConstraint, User> {
    @Override
    public void initialize(PasswordMatchConstraint passwordMatchConstraint) {
    }

    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
        return user.getPassword().equals(user.getMatchingpwd());
    }
}
