package jdbclearn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/app_db";
        String user = "app_user";
        String password = "app_pass";

        return DriverManager.getConnection(url, user, password);
    }
}
