package functionalprogramming;

import java.util.*;
import java.util.stream.Collectors;

public class FunctionsDemoCollections {
    private static final double DISCOUNT_RATE = 0.05;
    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        System.out.println(map.get(4));
        map.computeIfAbsent(4, key -> Integer.toString(key + 1));
        System.out.println(map.get(4));

        map.computeIfPresent(3, (key, value) -> key + " : " + value);
        System.out.println(map);

        map.computeIfAbsent(10, FunctionsDemoCollections::convertToString);
        System.out.println(map);

        List<Integer> scores = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        scores = scores.stream().map(score -> score + 10).toList();
        System.out.println(scores);
    }

    public static String convertToString(Integer val){
        return "abc" + val;
    }
}
