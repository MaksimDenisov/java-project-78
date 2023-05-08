package hexlet.code;

import java.util.Map;

public class MapSchema extends BaseSchema {
    private int mapSize = -1;

    @Override
    boolean isValid(Object obj) {
        Map map = getMap(obj);
        return isNotNull(map) && hasSize(map);
    }

    public MapSchema required() {
        return (MapSchema) super.required();
    }

    public MapSchema sizeof(int size) {
        mapSize = size;
        return this;
    }

    private Map getMap(Object o) {
        if (o instanceof Map) {
            return (Map) o;
        }
        return null;
    }

    private boolean hasSize(Map map) {
        return mapSize == -1 || map.size() == mapSize;
    }
}
