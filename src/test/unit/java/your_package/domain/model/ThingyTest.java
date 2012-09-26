package your_package.domain.model;

import org.junit.Test;
import your_package.test_utils.ValidationHelper;

import javax.validation.ConstraintViolation;
import java.util.Map;

import static org.junit.Assert.*;

public class ThingyTest {

    @Test
    public void should_ensure_mandatory_fields_are_not_null_or_blank() {
        Thingy thingy = new Thingy("");

        Map<String, ConstraintViolation<Thingy>> violations = ValidationHelper.validate(thingy);

        assertEquals("may not be empty", violations.get("name").getMessage());
    }

}
