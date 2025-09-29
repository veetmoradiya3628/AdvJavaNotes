package javacollectionframework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LLTest {
    public static void main(String[] args) {
        List<Integer> l1 = new LinkedList<>();
        l1.add(1);
        l1.add(2);
        System.out.println(l1);

        List<String> l2 = new ArrayList<>();
        l2.add("Veet");
        l2.add("Dhruvi");

        List<String> l3 = new ArrayList<>(Arrays.asList("R", "A", "B"));
        l2.addAll(l3);
        System.out.println(l2);
        System.out.println(l3);

        for(String item: l3){
            System.out.println(item);
        }
        System.out.println();
    }
}
