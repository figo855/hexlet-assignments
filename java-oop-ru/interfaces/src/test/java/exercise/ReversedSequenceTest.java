package exercise;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.Assertions.assertThat;

class ReversedSequenceTest {
    CharSequence text;
    @BeforeEach
    void createReversedSequence() {
        text = new ReversedSequence("abcdef");
    }
    @Test
    void toStringTest() {
        String expected = "fedcba";
        String actual = text.toString();
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void charAtTest() {
        char expected = 'e';
        char actual = text.charAt(1);
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void findLengthTest() {
        int expected = 6;
        int actual = text.length();
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void stringSubSequenceTest() {
        String expected = "edc";
        String actual = text.subSequence(1, 4).toString();
        assertThat(expected).isEqualTo(actual);
    }
}