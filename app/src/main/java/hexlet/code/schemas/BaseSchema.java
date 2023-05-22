package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {

    private final Map<String, Predicate> restrictions = new HashMap<>();
    private boolean required = false;

    /**
     * Checks if an object matches added restrictions.
     *
     * @param object Checked object.
     * @return True if the object is valid.
     */
    public boolean isValid(Object object) {
        try {
            return (!required && (object == null || "".equals(object)))
                    || (object != null && restrictions.values().stream().allMatch(p -> p.test(object)));
        } catch (ClassCastException e) {
            return false;
        }
    }

    /**
     * Adds restriction.
     *
     * @param name Constraint name.
     * @param predicate Condition.
     */
    protected void addRestriction(String name, Predicate predicate) {
        restrictions.put(name, predicate);
    }

    /**
     * If the required() method is called, null is considered invalid.
     *
     * @return This object.
     */
    public BaseSchema required() {
        required = true;
        return this;
    }
}
