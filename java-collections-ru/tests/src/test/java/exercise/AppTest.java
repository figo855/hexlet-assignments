package exercise;
// BEGIN
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {
    private static final List <Integer> LIST10 = List.of(1,2,3,4,5,6,7,8,9,10);
    private static final List <Integer> LISTEMPTY = new ArrayList<>();
    private static final int COUNT11 = 11;
    private static final int COUNT9 = 9;
    private  static final int COUNT0 = 0;

    @Test
    void testTake1() {


        assertThat(App.take(LIST10, COUNT11)).isEqualTo(LIST10);
    }

    @Test
    void testTake2() {

        assertThat(App.take(LIST10, COUNT9)).isEqualTo(LIST10.subList(0, 9));
    }

    @Test
    void testTake3() {
        assertThat(App.take(LISTEMPTY, COUNT9)).isEqualTo(LISTEMPTY);
    }

    @Test
    void testTake4() {
        assertThat(App.take(LIST10, COUNT0)).isEqualTo(LISTEMPTY);
    }

    @Test
    void testTake5() {
        assertThat(App.take(LISTEMPTY, COUNT0)).isEqualTo(LISTEMPTY);
    }
        // END
    }

