package exercise;

// BEGIN
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class App {
    public static void save(Path path, Car car) {
        // Path fullPath = Paths.get(path).toAbsolutePath().normalize();
        try {
            Files.writeString(path, car.serialize(), StandardOpenOption.WRITE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Car extract(Path path) throws Exception {
        // Path fullPath = Paths.get(path).toAbsolutePath().normalize();
        String content = "";
        try {
            content = Files.readString(path);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Car.unserialize(content);
    }
}
// END
