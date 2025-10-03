package test.unit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RandomTest {
    private static final StringBuilder output = new StringBuilder();

    @Test
    @Order(1)
    void firstTest(){
        output.append("firstTest");
    }

    @Test
    @Order(3)
    void thirdTest(){
        output.append(" thirdTest");
    }

    @Test
    @Order(2)
    void secondTest(){
        output.append(" secondTest");
    }

    @AfterAll
    public static void  assertOutput(){
        System.out.println(output);
        assertTrue(true);
    }

}
