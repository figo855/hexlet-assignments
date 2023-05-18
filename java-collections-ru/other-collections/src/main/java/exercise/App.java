package exercise;

// BEGIN
import java.util.*;

public class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> firstMap, Map<String, Object> secondMap) {

        Set<String> tempSet = new TreeSet<>();
        LinkedHashMap<String, String> resultMap = new LinkedHashMap<>();

        tempSet.addAll(firstMap.keySet());
        tempSet.addAll(secondMap.keySet());

        for (String key: tempSet) {
            if (!firstMap.containsKey(key) && secondMap.containsKey(key)) {
                resultMap.put(key, "added");
            } else if (firstMap.containsKey(key) && !secondMap.containsKey(key)) {
                resultMap.put(key, "deleted");
            } else if (firstMap.get(key).equals(secondMap.get(key))) {
                resultMap.put(key, "unchanged");
            } else if (!firstMap.get(key).equals(secondMap.get(key))) {
                resultMap.put(key, "changed");
            }
        }
        return resultMap;
    }
    }
//END
