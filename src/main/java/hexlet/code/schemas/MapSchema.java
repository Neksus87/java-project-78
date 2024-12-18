package hexlet.code.schemas;

import hexlet.code.Validator;
import java.util.Map;

public class MapSchema extends BaseSchema<Map<String, Object>> {
    private Integer size;
    private Map<String, BaseSchema<?>> schemas;

    public MapSchema(Validator validator) {
        super();
    }

    @Override
    public boolean isValid(Map<String, Object> value) {
        // Проверка, требуется ли заполнение или нет
        if (!isValidRequired(value)) {
            return false;
        }

        // Проверка на соответствие размеру
        if (size != null && value.size() != size) {
            return false;
        }

        // Проверка по схемам
        if (schemas != null) {
            for (Map.Entry<String, BaseSchema<?>> entry : schemas.entrySet()) {
                String key = entry.getKey();
                BaseSchema<?> schema = entry.getValue();
                Object val = value.get(key);
                if (!schema.isValid(val)) {
                    return false;
                }
            }
        }

        return true;
    }

    // Переопределяем метод проверки на обязательность
    @Override
    protected boolean isValidRequired(Map<String, Object> value) {
        return !required || (value != null && !value.isEmpty());
    }

    // Метод для установки обязательности
    public MapSchema required() {
        required = true;
        return this;
    }

    // Метод для установки размера
    public MapSchema sizeof(int size) {
        this.size = size;
        return this;
    }

    // Метод для установки схемы
    public MapSchema shape(Map<String, BaseSchema<?>> schemas) {
        this.schemas = schemas;
        return this;
    }
}
