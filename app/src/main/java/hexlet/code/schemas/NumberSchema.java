package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        addRestriction("integer", number -> number instanceof Integer);
    }

    public NumberSchema positive() {
        addRestriction("positive", number -> (int) number > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        addRestriction("range", number -> ((int) number >= min && (int) number <= max));
        return this;
    }
}
