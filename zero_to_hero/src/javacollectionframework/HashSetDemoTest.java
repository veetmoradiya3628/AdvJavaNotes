package javacollectionframework;

import java.util.HashSet;
import java.util.Random;

public class HashSetDemoTest {

    private static final String ALPHANUMERIC_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String generateRandomAlphanumericString(int length) {
        if (length <= 0){
            length = Math.abs(length);
        }

        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(ALPHANUMERIC_CHARS.length());
            sb.append(ALPHANUMERIC_CHARS.charAt(index));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        HashSet<Integer> hst = new HashSet<>();
        hst.add(1);
        hst.add(2);
        hst.add(1);
        hst.add(2);
        System.out.println(hst);

        hst.remove(1);
        System.out.println(hst);

        HashSet<String> stringSet = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            stringSet.add(generateRandomAlphanumericString(new Random().nextInt(20) + 1));
        }
        System.out.println(stringSet);
    }
}
