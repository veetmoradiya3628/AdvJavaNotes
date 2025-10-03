package jdbclearn;

import java.sql.*;

public class TestJdbcConnect {
    public static void main(String[] args) throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/app_db";
            String user = "app_user";
            String password = "app_pass";

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NOW() AS curr_time");

            while (rs.next()){
                System.out.println("DB Time : " + rs.getString("curr_time"));
            }

            System.out.println("meta data :- ");
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet catalogs = metaData.getCatalogs();
            while (catalogs.next()){
                String catalogName = catalogs.getString(1);
                System.out.println(catalogName);
            }

            rs.close();
            stmt.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
