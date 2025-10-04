package jdbclearn;

import java.sql.*;

public class DBOperations {
    public static void readDataFromDB() throws SQLException {
        String query = "SELECT * FROM user";
        try (var conn = DBUtils.getConnection();
             Statement statement = conn.createStatement()) {
            try (ResultSet rs = statement.executeQuery(query)) {
                while (rs.next()) {
                    System.out.println("===>");
                    System.out.println("ID:\t\t" + rs.getInt("id"));
                    System.out.println("First Name:\t\t" + rs.getString("first_name"));
                    System.out.println("Last Name:\t\t" + rs.getString("last_name"));
                    System.out.println("Email:\t\t" + rs.getString("email"));
                }
            }
        }
    }

    public static void updateQueryDB() throws SQLException {
        String query = "UPDATE user SET money = 120.00 WHERE id = 17";
        try (var conn = DBUtils.getConnection(); Statement statement = conn.createStatement()) {
            int rows = statement.executeUpdate(query);
            System.out.println(rows + " rows updated");
        }
    }

    public static void insertDataPrepared() throws SQLException {
        String query = "INSERT INTO user (first_name, last_name, email, fk_user_role, money) VALUES (?, ?, ?, ?, ?)";
        try (var conn = DBUtils.getConnection(); PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, "Veet");
            preparedStatement.setString(2, "Moradiya");
            preparedStatement.setString(3, "veetmoradiya@google.com");
            preparedStatement.setInt(4, 4);
            preparedStatement.setInt(5, 0);

            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " rows inserted");
        }
    }

    public static void callableStatement() throws SQLException {
        try (var conn = DBUtils.getConnection();
             CallableStatement callableStatement = conn.prepareCall("CALL select_user_by_email(?)")) {
            callableStatement.setString(1, "veetmoradiya@google.com");

            try (ResultSet rs = callableStatement.executeQuery()) {
                if (rs.next()) {
                    System.out.println("User's last name : " + rs.getString("last_name"));
                }
            }
        }
    }

    public static void transactionDemo() {
        String updateQuery = "UPDATE user SET money = ? WHERE id = ?";
        String selectQuery = "SELECT * FROM user WHERE id = ?";

        double moneyToTransfer = 80;
        int userFromId = 12;
        int userToId = 18;

        try (var conn = DBUtils.getConnection();
             var psSelect = conn.prepareStatement(selectQuery);
             var psUpdate = conn.prepareStatement(updateQuery);) {

            Savepoint savepoint = null;
            try {
                conn.setAutoCommit(false);

                psSelect.setInt(1, userFromId);
                try (var rs = psSelect.executeQuery()) {
                    if (rs.next() == true) {
                        double moneyAmount = rs.getDouble("money");
                        if (moneyToTransfer > moneyAmount) {
                            System.out.println("Not enough money for transfer");
                            return;
                        } else {
                            moneyAmount -= moneyToTransfer;
                            psUpdate.setDouble(1, moneyAmount);
                            psUpdate.setInt(2, userFromId);
                            psUpdate.executeUpdate();
                        }
                    }
                }

//				savepoint = conn.setSavepoint();

                psSelect.setInt(1, userToId);
                try (var rs = psSelect.executeQuery()) {
                    if (rs.next() == true) {
                        double moneyAmount = rs.getDouble("money");
                        moneyAmount += moneyToTransfer;
                        psUpdate.setDouble(1, moneyAmount);
                        psUpdate.setInt(2, userToId);
                        psUpdate.executeUpdate();
                    }
                }

                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
                conn.rollback();
//				conn.rollback(savepoint);
            }
            System.out.println("Money transferred");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void batchDemo() throws SQLException {
        try (var conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO user (first_name, last_name, email, fk_user_role, money) VALUES (?, ?, ?, ?, ?)")) {
            conn.setAutoCommit(false);

            try {
                ps.setString(1, "Dmytriy");
                ps.setString(2, "Voloshov");
                ps.setString(3, "d.voloshov@email.com");
                ps.setInt(4, 4);
                ps.setInt(5, 0);
                ps.addBatch();

                ps.setString(1, "Semen");
                ps.setString(2, "Zhukov");
                ps.setString(3, "s.zhukov@email.com");
                ps.setInt(4, 4);
                ps.setInt(5, 0);
                ps.addBatch();

                ps.setString(1, "Andrey");
                ps.setString(2, "Makarevych");
                ps.setString(3, "a.makarevych@email.com");
                ps.setInt(4, 4);
                ps.setInt(5, 0);
                ps.addBatch();

                ps.executeBatch();

                conn.commit();
                System.out.println("All records successfully inserted!");
            } catch (SQLException e) {
                e.printStackTrace();
                conn.rollback();
            }
        }
    }

    public static void main(String[] args) throws SQLException {
//        readDataFromDB();
//        updateQueryDB();
//        insertDataPrepared();
//        callableStatement();
//        transactionDemo();
        batchDemo();
    }
}
