import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import dao.UserDao;
import dao.UserDaoImpl;
import model.User;

public class MainApp {
	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserDao userDao = new UserDaoImpl(context.getBean("jdbcTemplate", org.springframework.jdbc.core.JdbcTemplate.class));

        // 1. Create table
        userDao.createTable();

        // 2. Insert users
        userDao.insert(new User(1, "Alice"));
        userDao.insert(new User(2, "Bob"));

        // 3. Read users
        System.out.println("All Users:");
        userDao.getAllUsers().forEach(System.out::println);

        // 4. Update user
        userDao.update(new User(2, "Charlie"));

        // 5. Delete user
        userDao.delete(1);

        System.out.println("After update & delete:");
        userDao.getAllUsers().forEach(System.out::println);

        context.close();
	}
}
