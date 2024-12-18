package hexlet.code.schemas;

public abstract class BaseSchema<T> {
    protected boolean required = false;

    protected boolean isValidRequired(T value) {
        return !required || value != null; // Вернет true, если required = false или value не null
    }

    // Добавляем абстрактный метод isValid
    public abstract boolean isValid(T value);
}
