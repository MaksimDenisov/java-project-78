package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringSchemaTest {
    private Validator validator;
    private StringSchema schema;

    @BeforeEach
    void beforeEach() {
        validator = new Validator();
        schema = validator.string();
    }

    @Test
    @DisplayName("As long as the required() method is not called, null and the empty string are considered valid.")
    void notRequiredTest() {
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));
    }

    @Test
    @DisplayName("If the required() method is called, null and the empty string are considered invalid.")
    void requiredTest() {
        schema.required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(5));
        assertTrue(schema.isValid("what does the fox say"));
        assertTrue(schema.isValid("hexlet"));
    }

    @Test
    @DisplayName("Considered valid if it contains a substrings.")
    void containsTest() {
        assertTrue(schema.contains("wh").isValid("what does the fox say"));
        assertTrue(schema.contains("what").isValid("what does the fox say"));
        assertFalse(schema.contains("whatthe").isValid("what does the fox say"));
        assertFalse(schema.isValid("what does the fox say"));
        // Here it is already false, since one more check contains("whatthe") has been added
    }

    @Test
    @DisplayName("Considered valid if the string is greater than the minimum length.")
    void minLengthTest() {
        assertFalse(schema.minLength(8).isValid("hexlet"));
        assertTrue(schema.minLength(6).isValid("hexlet"));
        // Here it is already false, since one more check contains("whatthe") has been added
    }
}
