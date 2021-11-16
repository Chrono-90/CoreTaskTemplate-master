package jm.task.core.jdbc.util;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private final static String HOST = "jdbc:mysql://localhost:3306/wwww";
    private final static String USERNAME = "root";
    private final static String PASS = "Romastebyapivo";

    public Connection getConnect() {
        Connection connection = null;
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(HOST, USERNAME, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
