package exercise;

// BEGIN
import java.util.Arrays;

public class App {
    public static String[][] enlargeArrayImage(String[][] array) {
        String[][] horizontaluStreched = Arrays.stream(array)
                .map(App::duplicateValues)
                .toArray(String[][]::new);

        return Arrays.stream(horizontaluStreched)
                .flatMap(item -> Arrays.stream(new String[][]{item, item}))
                .toArray(String[][]::new);
    }

    public static String[] duplicateValues (String[] items) {
        return Arrays.stream(items)
                .flatMap(item -> Arrays.stream(new String[]{item, item}))
                .toArray(String[]::new);
    }


    }

// END
