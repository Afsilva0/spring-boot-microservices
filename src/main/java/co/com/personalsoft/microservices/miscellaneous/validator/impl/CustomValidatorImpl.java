package co.com.personalsoft.microservices.miscellaneous.validator.impl;

import co.com.personalsoft.microservices.miscellaneous.validator.CustomValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomValidatorImpl implements ConstraintValidator<CustomValidator, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        if (value == null) {
            return false;
        }

        return value.length() == 9;
    }
}
