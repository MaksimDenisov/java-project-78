package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {

    private final List<Predicate> restrictions = new ArrayList<>();
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
                    || (object != null && restrictions.stream().allMatch(p -> p.test(object)));
        } catch (ClassCastException e) {
            return false;
        }
    }

    /**
     * Adds restriction.
     *
     * @param predicate Condition.
     */
    protected void addRestriction(Predicate predicate) {
        restrictions.add(predicate);
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
