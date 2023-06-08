package exercise;

import lombok.Data;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() {
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return json;
    }

//    public String serialize() throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonRepresentation = objectMapper.writeValueAsString(this);
//        return jsonRepresentation;
//    }

    public static Car unserialize(String json) {
        ObjectMapper mapper = new ObjectMapper();
        Car car = new Car(0, null, null, null, null);
        try {
            car = mapper.readValue(json, Car.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return car;
    }

//    public static Car unserialize(String jsonRepresentation) throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.readValue(jsonRepresentation, Car.class);
//    }
    // END
}
