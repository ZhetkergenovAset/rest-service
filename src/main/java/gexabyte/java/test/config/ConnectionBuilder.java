package gexabyte.java.test.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBuilder {
    private static String URL = "jdbc:postgresql://localhost:5432/test";
    private static String USER = "postgres";
    private static String PASSWORD = "mira1418";

    public static Connection build() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
