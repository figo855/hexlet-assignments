package exercise;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

// BEGIN
@Value
// END
class User {
    int id;
    String firstName;
    String lastName;
    int age;
}
