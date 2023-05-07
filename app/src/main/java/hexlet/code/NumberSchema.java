package hexlet.code;

public class NumberSchema extends BaseSchema {
    private int minValue = Integer.MIN_VALUE;
    private int maxValue = Integer.MAX_VALUE;
    private boolean positive = false;

    public NumberSchema positive() {
        positive = true;
        return this;
    }

    public NumberSchema required() {
        required = true;
        return this;
    }

    public NumberSchema range(int min, int max) {
        minValue = min;
        maxValue = max;
        return this;
    }

    @Override
    boolean isValid(Object obj) {
        Integer number = getInteger(obj);
        return isNotNull(number) && isPositive(number) && inTheRange(number);
    }

    private Integer getInteger(Object o) {
        if (o instanceof Integer) {
            return (Integer) o;
        }
        return null;
    }

    private boolean isPositive(Integer number) {
        return number == null || !positive || (number > 0);
    }

    private boolean inTheRange(Integer number) {
        return number == null || (number >= minValue && number <= maxValue);
    }

}
