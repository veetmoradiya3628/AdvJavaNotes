package jdbclearn.daolearn;

import java.util.List;

public interface UserDAO {
    void insertUser(User user);
    User getUserById(int id);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(int id);
}
