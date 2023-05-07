package hexlet.code;

import java.util.ArrayList;
import java.util.List;

public class StringSchema extends BaseSchema {
    private int minLength = 0;
    List<String> strings = new ArrayList<>();

    public StringSchema minLength(int length) {
        this.minLength = length;
        return this;
    }

    public StringSchema required() {
        this.required = true;
        return this;
    }

    public StringSchema contains(String str) {
        this.strings.add(str);
        return this;
    }

    public boolean isValid(Object obj) {
        String str = getString(obj);
        return isNotNull(str) && isNotEmpty(str) && hasMinLength(str) && isContainsAll(str);
    }

    private String getString(Object o) {
        if (o instanceof String) {
            return (String) o;
        }
        return null;
    }

    private boolean isNotEmpty(String str) {
        return !required || !str.isEmpty();
    }

    private boolean hasMinLength(String str) {
        return str == null || str.length() >= minLength;
    }

    private boolean isContainsAll(String str) {
        return str == null || (strings.stream().filter(str::contains).count() == strings.size());
    }
}
