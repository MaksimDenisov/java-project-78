package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberSchemaTest {
    Validator validator;
    NumberSchema schema;

    @BeforeEach
    void beforeEach() {
        validator = new Validator();
        schema = validator.number();
    }

    @Test
    @DisplayName("As long as the required() method is not called, null is considered valid.")
    void notRequiredTest() {
        assertTrue(schema.isValid(null)); // true
        assertTrue(schema.positive().isValid(null)); // true
    }

    @Test
    @DisplayName("If the required() method is called, null and not number are considered invalid.")
    void requiredTest() {
        schema.required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid("5"));
        assertTrue(schema.isValid(10));
    }

    @Test
    @DisplayName("If the positive() method is called, negative numbers and zero are considered invalid.")
    void positiveTest() {
        assertTrue(schema.isValid(-10));
        assertTrue(schema.isValid(0));
        schema.positive();
        assertFalse(schema.isValid(-10));
        assertFalse(schema.isValid(0));
    }

    @Test
    @DisplayName("If the positive() method is called, negative numbers and zero are considered invalid.")
    void rangeTest() {
        schema.range(5, 10);
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(4));
        assertFalse(schema.isValid(11));
    }
}
