package your_package.domain.model;

import static junit.framework.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Test;

public class ThingyTest {

    @Test
    public void should_ensure_mandatory_fields_are_not_null_or_blank() {
        Thingy thingy = new Thingy("");
        Map<String, ConstraintViolation<Thingy>> violationsMap = validate(thingy);
        assertTrue(violationsMap.get("name").getMessageTemplate().contains("NotEmpty"));
    }

    private <T> Map<String, ConstraintViolation<T>> validate(T user) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Map<String, ConstraintViolation<T>> violations = new HashMap<String, ConstraintViolation<T>>();
        for (ConstraintViolation<T> violation : validator.validate(user)) {
            violations.put(violation.getPropertyPath().toString(), violation);
        }
        return violations;
    }
}
