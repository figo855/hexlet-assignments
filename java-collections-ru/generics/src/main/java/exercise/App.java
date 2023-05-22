package exercise;
// BEGIN
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;


class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> listOfMaps1, Map<String, String> map2) {
        List<Map<String, String>> matchesList = new ArrayList<>();
        for (Map<String, String> map1 : listOfMaps1) {
            boolean find = true;
            for (Map.Entry map2Entry : map2.entrySet()) {
                String map1Value = map1.getOrDefault(map2Entry.getKey(), "");
                if (!map1Value.equals(map2Entry.getValue())) {
                    find = false;
                }

            }
            if (find == true) {
                matchesList.add(map1);
            }
        }
        return matchesList;
    }
}
//END
