package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map> {
    private Map<String, BaseSchema> keysSchemas = null;

    public MapSchema sizeof(int size) {
        addRestriction(map -> map.size() == size);
        return this;
    }

    public void shape(Map<String, BaseSchema> schemas) {
        keysSchemas = schemas;
    }

    @Override
    public boolean isValid(Object object) {
        return super.isValid(object) && keysValid((Map<String, Object>) object);
    }

    private boolean keysValid(Map<String, Object> map) {
        return keysSchemas == null || map.keySet().stream().allMatch(key -> keysSchemas.get(key).isValid(map.get(key)));
    }
}
