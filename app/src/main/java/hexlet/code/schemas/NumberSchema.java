package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        addRestriction(number -> number instanceof Integer);
    }

    public NumberSchema positive() {
        addRestriction(number -> (int) number > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        addRestriction(number -> ((int) number >= min && (int) number <= max));
        return this;
    }
}
