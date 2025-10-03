package basics;

public class Calculator {

    public Calculator() {
    }

    public int addition(int x, int y) {
        return x + y;
    }

    public int subtraction(int x, int y) {
        return x - y;
    }

    public int multiplication(int x, int y) {
        return x * y;
    }

    public int division(int x, int y) {
        if (y == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return x / y;
    }

    public int modulo(int x, int y) {
        if (y == 0) {
            throw new IllegalArgumentException("Cannot take modulo with zero");
        }
        return x % y;
    }
}

