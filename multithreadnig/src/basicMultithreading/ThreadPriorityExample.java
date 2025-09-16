package basicMultithreading;

public class ThreadPriorityExample {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority()); // 5

        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        System.out.println(Thread.currentThread().getPriority()); // 10


        System.out.println(Thread.currentThread().getName() + " says Hi!");
        Thread one = new Thread(() -> {
            System.out.println("Thread one says hi as well!");
        });
        one.setPriority(Thread.MAX_PRIORITY);
        one.start();
    }
}
