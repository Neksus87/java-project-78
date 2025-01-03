package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import hexlet.code.schemas.StringSchema;



public class ValidatorTest {
    @Test
    public void testRequired() {
        Validator v = new Validator();
        StringSchema schema = v.string().required();

        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertTrue(schema.isValid("hexlet"));
    }

    @Test
    public void testMinLength() {
        Validator v = new Validator();
        StringSchema schema = v.string().minLength(5);

        assertFalse(schema.isValid("hex"));
        assertTrue(schema.isValid("hexlet"));
    }

    @Test
    public void testContains() {
        Validator v = new Validator();
        StringSchema schema = v.string().contains("hex");

        assertTrue(schema.isValid("hexlet"));
        assertFalse(schema.isValid("let"));
    }

    @Test
    public void testMultipleConstraints() {
        Validator v = new Validator();
        StringSchema schema = v.string().required().minLength(5).contains("hex");

        assertTrue(schema.isValid("hexlet"));
        assertFalse(schema.isValid("let"));
        assertFalse(schema.isValid(null));
    }

    @Test
    public void testOverridingConstraints() {
        Validator v = new Validator();
        StringSchema schema = v.string().minLength(10).minLength(4);

        assertTrue(schema.isValid("Hexlet"));
    }
}
