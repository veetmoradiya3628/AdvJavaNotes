import entities.Gender;
import entities.lifecycle.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;

public class LifeCycleDemo {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        User user = new User("John", "Smith", "john.smith@email.com",
                new Date(), 30, Gender.MALE);

        entityManager.persist(user);
        long userId = user.getId();

        System.out.println("User ID after persist() method: " + userId);

        User userFromDb = entityManager.find(User.class, userId);
        System.out.println("User extracted from DB: " + userFromDb);

        entityManager.refresh(userFromDb);
        userFromDb.setEmail("j.smith@email.com");

        User user2 = new User("Michael", "Johnson", "michael.johnson@email.com",
                new Date(), 40, Gender.MALE);
        entityManager.persist(user2);
        entityManager.remove(user2);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        System.out.println("Entity is persisted successfully");
    }
}