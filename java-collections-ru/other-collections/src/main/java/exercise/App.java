package exercise;

// BEGIN
import java.util.*;

public class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> firstMap, Map<String, Object> secondMap) {

        Map <String, String> tempMap = new TreeMap<>();
        LinkedHashMap<String, String> resultMap = new LinkedHashMap<>();

        if

        for (Map.Entry<String, Object> map: firstMap.entrySet()) {
            if (map.getValue().equals(null) && !secondMap.get(map.getKey()).equals(null))
                tempMap.put(map.getKey(), "added");
            else if (!map.getValue().equals(null) && secondMap.get(map.getKey()).equals(null))
                tempMap.put(map.getKey(), "deleted");
            else if (map.getValue().equals(null) && secondMap.get(map.getKey()).equals(null)) {
                tempMap.put(map.getKey(), "unchanged");
            } else if (map.getValue().equals(secondMap.get(map.getKey())))
                tempMap.put(map.getKey(), "unchanged");
            else tempMap.put(map.getKey(), "changed");
        }
        resultMap.putAll(tempMap);
        return resultMap;
        }
    }
//END
