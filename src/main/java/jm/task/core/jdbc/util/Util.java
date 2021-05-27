package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Util {
    public static Connection getConnectionDB() throws Exception {
        final String DB_URL = "jdbc:mysql://localhost:3306/pp_1";
        final String USERNAME = "varejjjka";
        final String PASSWORD = "varejjjka";

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }
}
