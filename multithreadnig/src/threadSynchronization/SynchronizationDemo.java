package threadSynchronization;

public class SynchronizationDemo {

    private static int counter1 = 0;
    private static int counter2 = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment1();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment2();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Counter 1 value : " + counter1);
        System.out.println("Counter 2 value : " + counter2);
    }

    // critical section
    private synchronized static void increment1() {
        counter1++;
    }
    private synchronized static void increment2() {
        counter2++;
    }
}

/*
Non-atomic operation
1. load
2. increment
3. apply
 */

