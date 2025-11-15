package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    Main main = new Main();

    @Test
    void testAddPositiveNumbers() {
        assertEquals(7, main.add(3, 4));
    }

    @Test
    void testAddNegativeNumbers() {
        assertEquals(-10, main.add(-6, -4));
    }

    @Test
    void testAddWithZero() {
        assertEquals(5, main.add(5, 0));
    }

    @Test
    void testDivideValidCase() {
        assertEquals(5, main.divide(10, 2));
    }

    @Test
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> main.divide(5, 0));
    }

    @Test
    void testIsEvenTrue() {
        assertTrue(main.isEven(8));
    }

    @Test
    void testIsEvenFalse() {
        assertFalse(main.isEven(7));
    }

    @Test
    void testIsEvenZero() {
        assertTrue(main.isEven(0));
    }
}
