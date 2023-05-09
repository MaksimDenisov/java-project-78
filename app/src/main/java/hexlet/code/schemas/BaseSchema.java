package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {

    private final List<Predicate<T>> restrictions = new ArrayList<>();

    /**
     * Checks if an object matches added restrictions.
     *
     * @param object Checked object.
     * @return True if the object is valid.
     */
    public boolean isValid(Object object) {
        try {
            return restrictions.stream().allMatch(p -> p.test((T) object));
        } catch (ClassCastException e) {
            return false;
        }
    }

    /**
     * Adds restriction.
     *
     * @param predicate Condition.
     * @return Id of added restriction.
     */
    protected int addRestriction(Predicate<T> predicate) {
        restrictions.add(predicate);
        return restrictions.size() - 1;
    }

    /**
     * Replaces restriction.
     *
     * @param id        Id of restriction.
     * @param predicate Condition.
     */
    protected void replaceRestriction(int id, Predicate<T> predicate) {
        restrictions.set(id, predicate);
    }

    /**
     * If the required() method is called, null is considered invalid.
     *
     * @return This object.
     */
    public BaseSchema<T> required() {
        addRestriction(Objects::nonNull);
        return this;
    }
}
