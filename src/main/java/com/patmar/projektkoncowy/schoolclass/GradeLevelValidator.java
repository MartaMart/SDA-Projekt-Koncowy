package com.patmar.projektkoncowy.schoolclass;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
class GradeLevelValidator implements ConstraintValidator<GradeLevelConstraint, String> {

    private final SchoolClassRepository schoolClassRepository;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        List<SchoolClass> all = schoolClassRepository.findAll();
        if (all.isEmpty()) {
            return true;
        }

        Optional<String> gradeLevelWhichProbablyExist =
                all.stream().map(SchoolClass::getGradeLevel).filter(e -> e.equalsIgnoreCase(s)).findFirst();

        return gradeLevelWhichProbablyExist.isEmpty();
    }
}