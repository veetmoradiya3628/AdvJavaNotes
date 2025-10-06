package dao;

import java.util.List;

import model.User;

public interface UserDao {
	void createTable();
    void insert(User user);
    List<User> getAllUsers();
    void update(User user);
    void delete(int id);
}
