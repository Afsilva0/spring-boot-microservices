package co.com.personalsoft.microservices.miscellaneous.validator.impl;

import co.com.personalsoft.microservices.miscellaneous.validator.CustomValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomValidatorImpl implements ConstraintValidator<CustomValidator, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {

        if (value == null) {
            return false;
        }

        return value.toString().length() == 2;
    }
}
