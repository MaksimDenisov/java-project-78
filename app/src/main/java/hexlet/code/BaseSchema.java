package hexlet.code;

public abstract class BaseSchema {

    protected boolean required = false;

    abstract boolean isValid(Object obj);

    protected boolean isNotNull(Object o) {
        return !required || !(o == null);
    }
}
