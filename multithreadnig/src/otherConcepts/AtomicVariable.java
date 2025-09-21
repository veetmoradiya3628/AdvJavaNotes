package otherConcepts;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariable {
    private static int count = 0;
    private static final AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
//                count++;
                counter.incrementAndGet();
            }
        });

        Thread two = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
//                count++;
                counter.incrementAndGet();
            }
        });

        one.start();
        two.start();

        one.join();
        two.join();

//        System.out.println("Count value is : " + count);
        System.out.println("Counter value is : " + counter);
    }
}
