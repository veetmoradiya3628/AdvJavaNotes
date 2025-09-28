package basics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class exceptionTest {
    static void fun() throws IllegalAccessException {
        System.out.println("Inside fun()");
        throw new IllegalAccessException("demo");
    }

    public static void main(String[] args) {
        // unchecked exception
//        String name = null;
//        System.out.println(name.length());

        // checked exception
        try {
            Files.readAllLines(Paths.get("./test.txt"));
        }catch (IOException e){
            System.out.println("File does not exists");
            System.out.println(e.getCause());;
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        } finally {
            System.out.println("Finally block");
        }

//        try {
//            throw new MyCustomException("This is custom exception");
//        } catch (MyCustomException e) {
//            throw new RuntimeException(e);
//        }

        try {
            fun();
        }catch (IllegalAccessException e){
            System.out.println("Caught in main");
        }
    }
}

class MyCustomException extends Exception {
    public MyCustomException(String m){
        super(m);
    }
}