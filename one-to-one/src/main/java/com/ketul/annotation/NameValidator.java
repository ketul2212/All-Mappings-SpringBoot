package com.ketul.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class NameValidator implements ConstraintValidator<NameChecker, String> {

    List<String> names = Arrays.asList("null", null);

    @Override
    public void initialize(NameChecker nameChecker) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        System.out.println(value);
        return !names.contains(value);
    }
}
