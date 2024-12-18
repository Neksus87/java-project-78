package hexlet.code.schemas;

import hexlet.code.Validator;

public class NumberSchema extends BaseSchema<Number> {
    private final Validator validator;
    private Double rangeStart = null;
    private Double rangeEnd = null;
    private boolean positive = false;

    public NumberSchema(Validator validator) {
        this.validator = validator;
    }

    public NumberSchema required() {
        required = true;
        return this;
    }

    public NumberSchema positive() {
        positive = true;
        return this;
    }

    public NumberSchema range(double start, double end) {
        rangeStart = start;
        rangeEnd = end;
        return this;
    }

    @Override
    public boolean isValid(Number value) {
        if (!isValidRequired(value)) {
            return false;
        }

        if (positive && (value.doubleValue() <= 0)) {
            return false;
        }

        if (rangeStart != null && rangeEnd != null) {
            if (value.doubleValue() < rangeStart || value.doubleValue() > rangeEnd) {
                return false;
            }
        }

        return true;
    }
}
