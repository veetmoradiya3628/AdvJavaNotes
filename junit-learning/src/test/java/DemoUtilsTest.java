import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class DemoUtilsTest {

    @Test
    public void testEqualsAndNotEquals() {
        // setup
        DemoUtils demoUtils = new DemoUtils();

        int expected = 6;
        int unexpected = 8;

        // execute
        int actual = demoUtils.add(2, 4);

        // assert
        Assertions.assertEquals(expected, actual, "2+4 must be 6");
    }
}
