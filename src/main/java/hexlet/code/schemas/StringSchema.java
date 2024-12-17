package hexlet.code.schemas;

import hexlet.code.Validator;

public class StringSchema {
    private final Validator validator;
    private boolean required = false;
    private Integer minLength = null;
    private String contains = null;

    public StringSchema(Validator validator) {
        this.validator = validator;
    }

    public StringSchema required() {
        required = true;
        return this;
    }

    public StringSchema minLength(int length) {
        minLength = length;
        return this;
    }

    public StringSchema contains(String substring) {
        contains = substring;
        return this;
    }

    public boolean isValid(String value) {
        if (required) {
            if (value == null || value.isEmpty()) {
                return false;
            }
        }

        if (minLength != null && value.length() < minLength) {
            return false;
        }

        if (contains != null && !value.contains(contains)) {
            return false;
        }

        return true;
    }
}
