package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {

    private final List<Predicate<T>> restrictions = new ArrayList<>();

    public boolean isValid(Object object) {
        try {
            return restrictions.stream().allMatch(p -> p.test((T) object));
        } catch (ClassCastException e) {
            return false;
        }
    }

    protected int addRestriction(Predicate<T> predicate) {
        restrictions.add(predicate);
        return restrictions.size() - 1;
    }

    protected void replaceRestriction(int id, Predicate<T> predicate) {
        restrictions.set(id, predicate);
    }

    protected BaseSchema<T> required() {
        addRestriction(Objects::nonNull);
        return this;
    }
}
