package javacollectionframework;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class QueueDequeTest {
    public static void main(String[] args) {
        Deque<Integer> q1 = new ArrayDeque<>();
        q1.add(1);
        q1.add(2);
        q1.add(2);
        q1.add(2);
        q1.add(3);
        q1.add(3);

        System.out.println(q1);
        System.out.println(q1.peek());
        System.out.println(q1.poll());
        System.out.println(q1);

        List<Integer> l = q1.stream().filter(element -> element.compareTo(2) == 0).toList();
        System.out.println("l : " + l);

        System.out.println(q1.peekFirst());
        System.out.println(q1.peekLast());
        System.out.println(q1.pollFirst());
        System.out.println(q1.pollLast());
        System.out.println(q1);

        System.out.println(q1.isEmpty());
    }
}
