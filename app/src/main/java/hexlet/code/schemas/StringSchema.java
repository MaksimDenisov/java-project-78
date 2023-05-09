package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {
    private int minLengthPredicateId = -1;

    @Override
    public StringSchema required() {
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
