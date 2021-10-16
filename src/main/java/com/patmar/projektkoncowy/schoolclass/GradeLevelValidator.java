package com.patmar.projektkoncowy.schoolclass;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
@RequiredArgsConstructor
class GradeLevelValidator implements ConstraintValidator<GradeLevelConstraint,String> {

    private final SchoolClassRepository schoolClassRepository;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        List<SchoolClass> all = schoolClassRepository.findAll();
        String searchedGradeLevel =
                all.stream()
                        .map(SchoolClass::getGradeLevel)
                        .filter(e -> e.equalsIgnoreCase(s))
                        .findFirst()
                        .orElseThrow(()->new GradeLevelAlreadyExistsException(s));
        return true;
    }
}
