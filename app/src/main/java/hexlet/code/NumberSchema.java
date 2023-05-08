package hexlet.code;

public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema() {
        addClassChecking(Integer.class);
    }

    public NumberSchema positive() {
        addRestriction(number -> number == null || (number > 0));
        return this;
    }

    public NumberSchema range(int min, int max) {
        addRestriction(number -> number == null || (number >= min && number <= max));
        return this;
    }
}
