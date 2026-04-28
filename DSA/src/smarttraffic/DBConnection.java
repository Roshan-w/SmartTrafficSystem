package smarttraffic;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/smarttraffic";
    private static final String USER = "root";       // change if needed
    private static final String PASSWORD = "1977"; // change

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}