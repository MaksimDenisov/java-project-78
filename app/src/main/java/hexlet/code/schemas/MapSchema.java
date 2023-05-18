package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {

    public MapSchema sizeof(int size) {
        addRestriction(map -> ((Map) map).size() == size);
        return this;
    }

    public void shape(Map<String, BaseSchema> schemas) {
        if (schemas != null) {
            schemas.keySet().forEach(key -> addRestriction(map -> schemas.get(key).isValid(((Map) map).get(key))));
        }
    }
}
