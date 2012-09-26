package your_package.test_utils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.HashMap;
import java.util.Map;

public class ValidationHelper {
    public static <T> Map<String, ConstraintViolation<T>> validate(T user) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Map<String, ConstraintViolation<T>> violations = new HashMap<String, ConstraintViolation<T>>();
        for (ConstraintViolation<T> violation : validator.validate(user)) {
            violations.put(violation.getPropertyPath().toString(), violation);
        }
        return violations;
    }
}
