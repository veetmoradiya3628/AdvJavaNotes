package basics;

import java.util.Optional;
import java.util.Random;

public class OptionalDemo {
    public static void main(String[] args) {
        String[] words = new String[10];
        Optional<String> checkNull = Optional.ofNullable(words[5]);
        if (checkNull.isPresent()) {
            String word = words[5].toLowerCase();
            System.out.println(word);
        } else {
            System.out.println("Word is null");
        }

        int index = new Random().nextInt(10);
        words[index] = "Welcome to optional API";
        if (Optional.ofNullable(words[2]).isPresent()) {
            System.out.println("word at index 2 present");
        } else {
            System.out.println("word at index 2 is not present");
        }
    }
}
