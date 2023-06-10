package exercise;

// BEGIN
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

class Validator {
    public static List<String> validate(Address address) {
        List<String> notValidFields = new ArrayList<>();
        Class adressClass = address.getClass();
        Field[] fields = adressClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    field.setAccessible(true);
                    if (field.get(address) == null)
                        notValidFields.add(field.getName());
                    field.setAccessible(false);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return notValidFields;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> notValidFields = new HashMap<>();
        List<Field> fields = new ArrayList<>(Arrays.asList(address.getClass().getDeclaredFields()));
        Iterator<Field> iterator = fields.iterator();
//        Iterator<Field> iterator = new Iterator<>()
//        {
//            private int i = 0;
//            @Override
//            public boolean hasNext() {
//                return fields.length > i;
//            }
//            @Override
//            public Field next() {
//                return fields[i++];
//            }
//        };
        while (iterator.hasNext()) {
            Field field = iterator.next();
            List<String> tempList = new ArrayList<>();
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    field.setAccessible(true);
                    if (field.get(address) == null) {
                        tempList.add("can not be null");
                        notValidFields.put(field.getName(), List.of());
//                        iterator.remove();
                    }
                    field.setAccessible(false);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
//        for (Field field : address.getClass().getDeclaredFields()) {
//            List<String> tempList = new ArrayList<>();
//            if (field.isAnnotationPresent(NotNull.class)) {
//                try {
//                    field.setAccessible(true);
//                    if (field.get(address) == null) {
//                        tempList.add("can not be null");
//                        notValidFields.put(field.getName(), List.of());
//                    }
//                    field.setAccessible(false);
//                } catch (IllegalAccessException e) {
//                    throw new RuntimeException(e);
//                }
            } if (field.isAnnotationPresent(MinLength.class)) {
                try {
                    field.setAccessible(true);
                    if (field.get(address) != null) {
                        if (field.get(address).toString().length() < field.getAnnotation(MinLength.class).minLength()) {
                            tempList.add("length less than " + field.getAnnotation(MinLength.class).minLength());
                            notValidFields.put(field.getName(), List.of());
                        }
                        field.setAccessible(false);
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }

            }
//            field.setAccessible(true);
            if (notValidFields.containsKey(field.getName()))
                notValidFields.put(field.getName(), tempList);
//            field.setAccessible(false);
        }
        return notValidFields;
    }
}

//import java.lang.reflect.Field;
//import java.util.List;
//import java.util.ArrayList;
//import java.util.Map;
//import java.util.HashMap;
//import java.util.stream.Collectors;

//class Validator {
//    public static List<String> validate(Object instance) {
//        List<Field> fields = List.of(instance.getClass().getDeclaredFields());
//        return fields.stream()
//                .filter(field -> field.isAnnotationPresent(NotNull.class))
//                .filter(field -> {
//                    Object value;
//                    try {
//                        field.setAccessible(true);
//                        value = field.get(instance);
//                        field.setAccessible(false);
//                    } catch (Exception e) {
//                        throw new RuntimeException(e);
//                    }
//                    return value == null;
//                })
//                .map(Field::getName)
//                .collect(Collectors.toList());
//    }
//
//    public static Map<String, List<String>> advancedValidate(Object instance) {
//        List<Field> fields = List.of(instance.getClass().getDeclaredFields());
//        Map<String, List<String>> validationErrors = new HashMap<>();
//        fields.stream()
//                .filter(field -> field.isAnnotationPresent(NotNull.class) || field.isAnnotationPresent(MinLength.class))
//                .forEach(field -> {
//                    String fieldName = field.getName();
//                    List<String> errors = getErrorsForField(field, instance);
//                    if (!errors.isEmpty()) {
//                        validationErrors.put(fieldName, errors);
//                    }
//                });
//        return validationErrors;
//    }
//
//    public static List<String> getErrorsForField(Field field, Object instance) {
//        List<String> errors = new ArrayList<>();
//        String value;
//
//        try {
//            field.setAccessible(true);
//            value = (String) field.get(instance);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//        if (field.isAnnotationPresent(NotNull.class) && value == null) {
//            errors.add("can not be null");
//        }
//
//        if (field.isAnnotationPresent(MinLength.class)) {
//            int minLength = field.getAnnotation(MinLength.class).minLength();
//            if (value == null || value.length() < minLength) {
//                errors.add("length less than " + minLength);
//            }
//        }
//        return errors;
//    }
//}
// END
