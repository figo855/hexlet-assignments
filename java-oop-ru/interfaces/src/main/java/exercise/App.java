package exercise;

// BEGIN
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static List<String> buildApartmentsList(List<Home> listHome, int n) {
        return listHome.stream()
                .sorted()
                .limit(n)
                .map(x -> x.toString())
                .collect(Collectors.toList());
    }
}
// END
