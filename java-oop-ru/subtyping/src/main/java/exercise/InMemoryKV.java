package exercise;

// BEGIN
import java.util.Map;
import java.util.HashMap;

public class InMemoryKV implements KeyValueStorage {

    private Map<String, String> dataBase = new HashMap<>();

    public InMemoryKV (Map<String, String> map) {
        dataBase.putAll(map);
    }
    @Override
    public void set(String key, String value) {
        dataBase.put(key, value);
    }

    @Override
    public void unset(String key) {
        dataBase.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return dataBase.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(dataBase);
    }
}
// END
