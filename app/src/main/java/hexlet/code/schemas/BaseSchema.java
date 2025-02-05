package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {

    private Map<String, Predicate<T>> schemeRules = new LinkedHashMap<>();

    protected final void addRule(String rule, Predicate<T> ruleLogic) {
        schemeRules.put(rule, ruleLogic);
    }

    public final boolean isValid(T testedValue) {
        return schemeRules.values()
                .stream()
                .allMatch(predicate -> predicate.test(testedValue));
    }
}
