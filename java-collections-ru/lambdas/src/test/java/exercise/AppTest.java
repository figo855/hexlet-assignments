package exercise;
// BEGIN
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class AppTest {

    @Test
    void testEnlargeArrayImage1() {

        String[][] image1 = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"},
        };

        String[][] enlargedImage1 = {
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
        };
        String[][] actual1 = App.enlargeArrayImage(image1);
        assertThat(actual1).isEqualTo(enlargedImage1);
    }

        @Test
        void testEnlargeArrayImage2() {

            String[][] image2 = {
                    {" ", " ", "*", " ", " "},
                    {" ", "*", " ", "*", " "},
                    {" ", "*", " ", "*", " "},
                    {"*", " ", " ", " ", "*"},
                    {"*", " ", " ", " ", "*"},
                    {" ", "*", " ", "*", " "},
                    {" ", "*", " ", "*", " "},
                    {" ", " ", "*", " ", " "},
            };

            String[][] enlargedImage2 = {
                    {" ", " ", " ", " ", "*", "*", " ", " ", " ", " "},
                    {" ", " ", " ", " ", "*", "*", " ", " ", " ", " "},
                    {" ", " ", "*", "*", " ", " ", "*", "*", " ", " "},
                    {" ", " ", "*", "*", " ", " ", "*", "*", " ", " "},
                    {" ", " ", "*", "*", " ", " ", "*", "*", " ", " "},
                    {" ", " ", "*", "*", " ", " ", "*", "*", " ", " "},
                    {"*", "*", " ", " ", " ", " ", " ", " ", "*", "*"},
                    {"*", "*", " ", " ", " ", " ", " ", " ", "*", "*"},
                    {"*", "*", " ", " ", " ", " ", " ", " ", "*", "*"},
                    {"*", "*", " ", " ", " ", " ", " ", " ", "*", "*"},
                    {" ", " ", "*", "*", " ", " ", "*", "*", " ", " "},
                    {" ", " ", "*", "*", " ", " ", "*", "*", " ", " "},
                    {" ", " ", "*", "*", " ", " ", "*", "*", " ", " "},
                    {" ", " ", "*", "*", " ", " ", "*", "*", " ", " "},
                    {" ", " ", " ", " ", "*", "*", " ", " ", " ", " "},
                    {" ", " ", " ", " ", "*", "*", " ", " ", " ", " "},
            };

            String[][] actual2 = App.enlargeArrayImage(image2);
            assertThat(actual2).isEqualTo(enlargedImage2);
        }

        @Test
        void testEnlargeArrayImage() {
            String[][] image3 = {
                    {"@", "@"},
                    {"@", "|"},
                    {"—", "|"},
                    {"@", "|"},
                    {"@", "@"},
            };

            String[][] enlargedImage3 = {
                    {"@", "@", "@", "@"},
                    {"@", "@", "@", "@"},
                    {"@", "@", "|", "|"},
                    {"@", "@", "|", "|"},
                    {"—", "—", "|", "|"},
                    {"—", "—", "|", "|"},
                    {"@", "@", "|", "|"},
                    {"@", "@", "|", "|"},
                    {"@", "@", "@", "@"},
                    {"@", "@", "@", "@"},
            };

            String[][] actual3 = App.enlargeArrayImage(image3);
            assertThat(actual3).isEqualTo(enlargedImage3);
        }
    }

// END
