package javacollectionframework;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemoTest {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> lhm
                = new LinkedHashMap<Integer, String>();

        lhm.put(3, "Geeks");
        lhm.put(2, "For");
        lhm.put(1, "Geeks");
        System.out.println(lhm);
    }
}
