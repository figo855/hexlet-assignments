package exercise;

// BEGIN
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> newMap = new HashMap<>(storage.toMap());
        for (Map.Entry<String, String> item: newMap.entrySet()) {
            storage.set(item.getValue(), item.getKey());
            storage.unset(item.getKey());
        }
    }
}
// END
