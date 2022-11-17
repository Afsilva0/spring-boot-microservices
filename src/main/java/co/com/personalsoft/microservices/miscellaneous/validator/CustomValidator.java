package co.com.personalsoft.microservices.miscellaneous.validator;


import co.com.personalsoft.microservices.miscellaneous.validator.impl.CustomValidatorImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CustomValidatorImpl.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomValidator {
    String message() default "Invalid field";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
