package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List <Integer> list10 = List.of(1,2,3,4,5,6,7,8,9,10);
        List <Integer> listEmpty = new ArrayList<>();
        int count11 = 11;
        int count9 = 9;
        int count0 = 0;

        assertThat(App.take(list10, count11)).isEqualTo(list10);

        assertThat(App.take(list10, count9)).isEqualTo(list10.subList(0, 8));

        assertThat(App.take(listEmpty, count9)).isEqualTo(listEmpty);

        assertThat(App.take(list10, count0)).isEqualTo(listEmpty);

        assertThat(App.take(listEmpty, count0)).isEqualTo(listEmpty);

        // END
    }
}
