package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String string;
    public ReversedSequence(String string) {
        this.string = string;
    }

    public String toString() {
        char chars[] = string.toCharArray();
        String revString = "";
        for (int i = chars.length-1; i>=0; i--) {
            revString = revString + chars[i];
        }
        return revString;
    }

    public char charAt(int numberOfChar) {
        return toString().charAt(numberOfChar);

    }

    public int length() {
        return string.length();
    }

    public String subSequence(int start, int end) {
        return toString().substring(start, end);
    }
}
// END
