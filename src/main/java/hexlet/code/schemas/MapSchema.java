package hexlet.code.schemas;

import hexlet.code.Validator;
import java.util.Map;

public class MapSchema extends BaseSchema<Map<?, ?>> {
    private boolean required = false;
    private Integer size = null;

    public MapSchema(Validator validator) {
        super();
    }

    @Override
    public boolean isValid(Map<?, ?> value) {
        if (!isValidRequired(value)) {
            return false;
        }

        if (size != null && value.size() != size) {
            return false;
        }

        return true;
    }

    @Override
    protected boolean isValidRequired(Map<?, ?> value) {
        return !required || value != null;
    }

    public MapSchema required() {
        required = true;
        return this;
    }

    public MapSchema sizeof(int size) {
        this.size = size;
        return this;
    }
}
