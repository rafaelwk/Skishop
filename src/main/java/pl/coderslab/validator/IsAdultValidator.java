package pl.coderslab.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class IsAdultValidator implements ConstraintValidator<IsAdult, LocalDate> {

    @Override
    public void initialize(IsAdult isAdult) {

    }

    @Override
    public boolean isValid(LocalDate birthDate, ConstraintValidatorContext constraintValidatorContext) {
        if (birthDate ==null) return  false;
        LocalDate currentDate = LocalDate.now();
        LocalDate pastdate = currentDate.minusYears(18);
        return (birthDate.isBefore(pastdate) || birthDate.isEqual(pastdate));
    }
}
