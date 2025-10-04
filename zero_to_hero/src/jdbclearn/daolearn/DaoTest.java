package jdbclearn.daolearn;

public class DaoTest {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAOImpl();

        // Insert
        userDAO.insertUser(new User("Alice", "alice@example.com"));
        userDAO.insertUser(new User("Bob", "bob@example.com"));

        // Read
        System.out.println("All Users:");
        userDAO.getAllUsers().forEach(System.out::println);

        // Get by ID
        System.out.println("User with ID 1: " + userDAO.getUserById(1));

        // Update
        User userToUpdate = userDAO.getUserById(1);
        userToUpdate.setName("Alice Wonderland");
        userDAO.updateUser(userToUpdate);

        System.out.println("After Update: " + userDAO.getUserById(1));

        // Delete
        userDAO.deleteUser(2);
        System.out.println("After Delete:");
        userDAO.getAllUsers().forEach(System.out::println);
    }
}
