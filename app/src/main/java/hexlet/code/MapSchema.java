package hexlet.code;

import java.util.Map;

public class MapSchema extends BaseSchema<Map> {
    public MapSchema sizeof(int size) {
        addRestriction(map -> map.size() == size);
        return this;
    }
}
