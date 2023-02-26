package mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator
    implements ConstraintValidator<CourseCode, String> {

    private String[] coursePrefixes;

    @Override
    public void initialize(final CourseCode courseCode) {
        coursePrefixes = courseCode.value();
    }

    @Override
    public boolean isValid(
        final String code,
        final ConstraintValidatorContext context
    ) {
        boolean result = false;

        if (code != null) {
            for(String temp : coursePrefixes) {
                result = code.startsWith(temp);

                if (result) break;
            }
        } else {
            result = true;
        }

        return result;
    }
}
