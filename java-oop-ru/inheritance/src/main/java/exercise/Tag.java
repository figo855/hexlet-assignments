package exercise;

// BEGIN
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.Map;

public abstract class Tag {
    String name;
    Map<String, String> tags= new LinkedHashMap<>();
}
// END
