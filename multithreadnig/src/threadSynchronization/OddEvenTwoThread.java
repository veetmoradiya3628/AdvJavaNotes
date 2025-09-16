package threadSynchronization;

public class OddEvenTwoThread {
    private static final Object LOCK = new Object();
    private static int counter = 1; // start from 1
    private static final int MAX = 10; // print till 10

    public static void main(String[] args) {
        Thread oddThread = new Thread(() -> printOdd());
        Thread evenThread = new Thread(() -> printEven());

        oddThread.start();
        evenThread.start();
    }

    private static void printOdd() {
        synchronized (LOCK) {
            while (counter <= MAX) {
                if (counter % 2 == 1) {
                    System.out.println("odd  : " + counter);
                    counter++;
                    LOCK.notifyAll();
                } else {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static void printEven() {
        synchronized (LOCK) {
            while (counter <= MAX) {
                if (counter % 2 == 0) {
                    System.out.println("even : " + counter);
                    counter++;
                    LOCK.notifyAll();
                } else {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
