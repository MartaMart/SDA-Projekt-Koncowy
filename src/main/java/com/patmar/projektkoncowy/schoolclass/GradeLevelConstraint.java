package com.patmar.projektkoncowy.schoolclass;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = GradeLevelValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface GradeLevelConstraint {
    String message() default "Invalid grade level name.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
