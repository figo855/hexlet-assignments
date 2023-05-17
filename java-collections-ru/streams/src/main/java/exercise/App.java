package exercise;

// BEGIN
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class App {
    public static long getCountOfFreeEmails(List<String> emails) {
        return emails.stream()
                .map(email -> email.split("@")[1])
                .filter(email -> email.equals("gmail.com")||email.equals("yandex.ru")||email.equals("hotmail.com"))
                .count();

    }
}
// END
