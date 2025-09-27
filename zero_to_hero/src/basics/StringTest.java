package basics;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {
    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(s.length());
        System.out.println(s.contains("ll"));
        System.out.println(s.isEmpty());
        System.out.println(s.lastIndexOf('l'));
        System.out.println(s.lastIndexOf('L'));
        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());
        System.out.println(Arrays.toString(s.split("e")));

        String s2 = "Hello"; // object in stack
        System.out.println(s.equals(s2));
        System.out.println(s.charAt(1));

        String s3 = new String("Hello"); // object allocation in heap
        System.out.println(s2 == s3); // false
        System.out.println(s2 == s3.intern()); // true
        System.out.println(s2.equals(s3)); // true

        String s4 = "hello";
        System.out.println(s3 == s4); // false
        System.out.println(s3.equals(s4)); // false
        System.out.println(s3.equalsIgnoreCase(s4)); // true

        /**
         * \t - tab
         * \b - backspace
         * \n - new line
         * \r - carriage return
         * \f - form feed
         * \'
         * \"
         * \\
         */

        String gmailPattern = "[a-zA-Z-\\d]+@gmail\\.com";
        Pattern p = Pattern.compile(gmailPattern);

        String sampleText = "Some random text that contains gmail addresses " +
                "like this one some-email@gmail.com. And some other random text.";
        Matcher m = p.matcher(sampleText);
        m.find();

        String gmailAddress = m.group();
        System.out.println(gmailAddress);

        String sampleText2 = "There are three sentences in this string. Are you sure ? Yes!";
        String[] sentences = sampleText2.split("[.!?]");
        System.out.println(Arrays.toString(sentences));
    }
}
// heap has string pool
// string pool to cache and reuse String literals, saving memory and improving performance.