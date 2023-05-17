package exercise;

// BEGIN
import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> list) {
        return list.stream()
                .filter(human -> human.get("gender").equals("male"))
                .sorted((date1,date2) -> date1.get("birthday").compareTo(date2.get("birthday")))
                .map(name -> name.get("name"))
                .collect(Collectors.toList());

    }
}
// END
