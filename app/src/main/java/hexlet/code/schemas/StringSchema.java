package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {
    private int minLength = 1;

    public StringSchema() {
        addRestriction(s -> ((String) s).length() >= minLength);
    }

    public StringSchema minLength(int length) {
        minLength = length;
        return this;
    }

    public StringSchema contains(String str) {
        addRestriction(s -> ((String) s).contains(str));
        return this;
    }
}
