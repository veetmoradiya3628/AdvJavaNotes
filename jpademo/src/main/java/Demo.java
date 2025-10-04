import entities.Gender;
import entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        User user = new User("John", "Smith", "john.smith@email.com", new Date(), 30, Gender.MALE);

        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.clear();
        entityManagerFactory.close();

        System.out.println("Entity is persisted successfully!");
    }
}
