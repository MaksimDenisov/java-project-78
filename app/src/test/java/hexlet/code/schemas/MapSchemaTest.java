package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MapSchemaTest {
    private Validator validator;
    private MapSchema schema;

    @BeforeEach
    void beforeEach() {
        validator = new Validator();
        schema = validator.map();
    }

    @Test
    @DisplayName("As long as the required() method is not called, null is considered valid.")
    void notRequiredTest() {
        assertTrue(schema.isValid(null)); // true
    }

    @Test
    @DisplayName("If the required() method is called, null is considered invalid.")
    void requiredTest() {
        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap()));
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data)); // true
    }

    @Test
    @DisplayName("The number of key-value pairs in the Map object must be equal to the specified.")
    void sizeofTest() {
        Map<String, String> data = new HashMap<>();
        schema.sizeof(2);
        data.put("key1", "value1");
        assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        assertTrue(schema.isValid(data));
    }
}
