package javacollectionframework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class IteratorTest {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        List<Integer> int1 = new CopyOnWriteArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        iterator = int1.iterator();
        while (iterator.hasNext()) {
            int nextInt = iterator.next();
            if (nextInt % 2 == 0) {
                int1.remove(Integer.valueOf(nextInt));
            }
        }
        System.out.println("int1 : " + int1);

        List<String> lst = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five"));
        Iterator<String> iteratorStr = lst.iterator();
        while (iteratorStr.hasNext()){
            System.out.print(iteratorStr.next() + " ");
        }
    }
}
