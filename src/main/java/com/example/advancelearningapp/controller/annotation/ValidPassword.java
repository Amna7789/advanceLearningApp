package com.example.advancelearningapp.controller.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
@Documented
@Constraint(validatedBy = PasswordConstraintValidator.class)

@Target(ElementType.METHOD)

@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {
    String message() default "Invalid Password";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {

    };

}
