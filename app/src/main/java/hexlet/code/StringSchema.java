package hexlet.code;

public class StringSchema extends BaseSchema<String> {
    int minLengthPredicateId = -1;

    @Override
    public BaseSchema<String> required() {
        super.required();
        addRestriction(s -> !s.isEmpty());
        return this;
    }

    public StringSchema minLength(int length) {
        if (minLengthPredicateId < 0) {
            minLengthPredicateId = addRestriction(s -> s.length() >= length);
        } else {
            replaceRestriction(minLengthPredicateId, s -> s.length() >= length);
        }
        return this;
    }

    public StringSchema contains(String str) {
        addRestriction(s -> s.contains(str));
        return this;
    }
}
