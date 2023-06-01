package exercise;

// BEGIN
public class NegativeRadiusException extends Exception {
    public NegativeRadiusException (String description) {
        super(description);
    }
    public NegativeRadiusException() {
        super();
    }
}
// END
