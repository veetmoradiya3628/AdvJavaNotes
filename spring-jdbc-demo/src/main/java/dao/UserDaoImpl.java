package dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import model.User;

public class UserDaoImpl implements UserDao {
	private JdbcTemplate jdbcTemplate;

	public UserDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void createTable() {
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY, name VARCHAR(50))");
	}

	@Override
	public void insert(User user) {
		jdbcTemplate.update("INSERT INTO users (id, name) VALUES (?, ?)", user.getId(), user.getName());
	}

	@Override
	public List<User> getAllUsers() {
		return jdbcTemplate.query("SELECT * FROM users",
				(rs, rowNum) -> new User(rs.getInt("id"), rs.getString("name")));
	}

	@Override
	public void update(User user) {
		jdbcTemplate.update("UPDATE users SET name = ? WHERE id = ?", user.getName(), user.getId());
	}

	@Override
	public void delete(int id) {
		jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
	}
}
