package com.ketul.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { NameValidator.class })
public @interface NameChecker {
    String message() default "Your name is not good";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}