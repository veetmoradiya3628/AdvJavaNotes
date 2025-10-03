package test.unit;

import basics.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    void testAddition() {
        Calculator c = new Calculator();
        assertEquals(5, c.addition(3, 2));
    }

    @Test
    void testSubtraction() {
        Calculator c = new Calculator();
        assertEquals(1, c.subtraction(3, 2));
    }

    @Test
    void testMultiplication() {
        Calculator c = new Calculator();
        assertEquals(6, c.multiplication(2, 3));
    }

    @Test
    void testDivision() {
        Calculator c = new Calculator();
        assertEquals(3, c.division(6, 2));
    }

    @Test
    void testDivisionByZeroThrowsException() {
        Calculator c = new Calculator();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            c.division(10, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    void testModulo() {
        Calculator c = new Calculator();
        assertEquals(1, c.modulo(5, 2));
    }

    @Test
    void testModuloByZeroThrowsException() {
        Calculator c = new Calculator();
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            c.modulo(10, 0);
        });
        assertEquals("Cannot take modulo with zero", e.getMessage());
    }
}
