import entities.Gender;
import entities.locking.EntityManagerHelper;
import entities.locking.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class LockingDemo {
    public static void main(String[] args) throws InterruptedException {
        createUserInDb();

        ExecutorService es = Executors.newFixedThreadPool(2);
        IntStream.range(0, 2).forEach(i -> {

            es.submit(() -> {
                EntityManager em = null;
                try {
                    em = EntityManagerHelper.getEntityManager();
                    EntityManagerHelper.beginTransaction();

                    // Lock at load time
                    User user = em.find(User.class, 1, LockModeType.PESSIMISTIC_WRITE);

                    String currentThreadName = Thread.currentThread().getName();
                    System.out.printf("Thread %s obtained lock on User entity with version %d%n",
                            currentThreadName, user.getVersion());

                    // Safe to modify after locking
                    user.setEmail(currentThreadName + "@.email.com");

                    EntityManagerHelper.commit();
                    System.out.printf("Thread %s: User version after commit is: %d%n", currentThreadName, user.getVersion());
                    System.out.printf("Thread %s: User email after commit is: %s%n", currentThreadName, user.getEmail());
                } catch (Exception e) {
                    e.printStackTrace();
                    EntityManagerHelper.rollback();
                } finally {
                    EntityManagerHelper.closeEntityManager();
                }
            });


//            es.submit(() -> {
//                try {
//                    EntityManager em = EntityManagerHelper.getEntityManager();
//                    EntityManagerHelper.beginTransaction();
//                    User user = em.find(User.class, 1);
//
//                    String currentThreadName = Thread.currentThread().getName();
//                    System.out.printf("Thread %s is about to lock User entity with version %d%n",
//                            currentThreadName, user.getVersion());
//                    user.setEmail(currentThreadName + "@.email.com");
////                    em.lock(user, LockModeType.PESSIMISTIC_FORCE_INCREMENT);
////					em.lock(user, LockModeType.PESSIMISTIC_WRITE);
//                    System.out.printf("Thread %s obtained lock on User entity with version %d%n",
//                            currentThreadName, user.getVersion());
//                    EntityManagerHelper.commit();
//                    System.out.printf("Thread %s: User version after commit is: %d%n", currentThreadName, user.getVersion());
//                    System.out.printf("Thread %s: User email after commit is: %s%n", currentThreadName, user.getEmail());
//
//                    EntityManagerHelper.closeEntityManager();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            });

        });
        es.shutdown();
        es.awaitTermination(10, TimeUnit.SECONDS);
        es.shutdownNow();

        EntityManagerHelper.closeEntityManagerFactory();
    }

    private static void createUserInDb() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        User user = new User("John", "Smith", "john.smith@email.com", new Date(), 30, Gender.MALE);

        em.persist(user);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }
}
