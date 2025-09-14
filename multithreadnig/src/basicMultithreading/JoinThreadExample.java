package basicMultithreading;

public class JoinThreadExample {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 1 : " + i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                System.out.println("Thread 2 : " + i);
            }
        });
        System.out.println("Before executing the threads");
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Done executing threads");
    }
}
