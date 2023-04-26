package exercise;
// BEGIN
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;


class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> listOfMaps, Map <String, String> map) {
            List<Map<String, String>> matchesList= new ArrayList<>();
            for (Map<String, String> mapLarge: listOfMaps) {
                boolean find = true;
                for (Map.Entry mapSmallPair: map.entrySet()) {
                    String mapLargePairValue = mapLarge.getOrDefault(mapSmallPair.getKey(), "");
                    if (mapLargePairValue.equals(mapSmallPair.getValue())) {
                        find = false;
                    }

                    }
                if (find==true) {
                    matchesList.add(mapLarge);
                }
            }
            return matchesList;
    }
}
//END
