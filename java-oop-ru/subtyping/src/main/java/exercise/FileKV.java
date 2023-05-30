package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage{
    private String path;

    public FileKV (String path, Map<String, String> initial) {
        this.path = path;
        initial.entrySet()
                .forEach(entry -> set(entry.getKey(), entry.getValue()));
    }
    @Override
    public void set(String key, String value) {
        String content = Utils.readFile(path);
        Map<String, String> data = Utils.unserialize(content);
        data.put(key, value);
        Utils.writeFile(path, Utils.serialize(data));
    }

    @Override
    public void unset(String key) {
        String content = Utils.readFile(path);
        Map<String, String> data = Utils.unserialize(content);
        data.remove(key);
        Utils.writeFile(path, Utils.serialize(data));
    }

    @Override
    public String get(String key, String defaultValue) {
        String content = Utils.readFile(path);
        Map<String, String> data = Utils.unserialize(content);
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        String content = Utils.readFile(path);
        Map<String, String> data = Utils.unserialize(content);
        return new HashMap<>(data);
    }


}
// END
