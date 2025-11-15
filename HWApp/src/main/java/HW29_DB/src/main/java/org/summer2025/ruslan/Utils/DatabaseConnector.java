package org.summer2025.ruslan.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseConnector {
    private static final Properties DB_CONFIG = new Properties();
    private static final String URL_KEY = "db.url";
    private static final String USER_KEY = "db.user";
    private static final String PASSWORD_KEY = "db.password";
    private static Connection connection;


    static {
        loadDriver();
        loadConfigDB();

    }

    private DatabaseConnector() {
    }

    private static void loadConfigDB() {
        InputStream inStream = DatabaseConnector.class.getClassLoader().getResourceAsStream("configs/DB.properties");
        try {
            DB_CONFIG.load(inStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getValue(String key) {
        return DB_CONFIG.getProperty(key);
    }

    private static void loadDriver() {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        DatabaseConnector.getValue(URL_KEY),
                        DatabaseConnector.getValue(USER_KEY),
                        DatabaseConnector.getValue(PASSWORD_KEY)
                );
                System.out.println("Connection to DB...");
                return connection;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Connection is ready");
        return connection;

    }

    public static void close() {
        try {
            Statement stmt = connection.createStatement();
            stmt.execute("DROP TABLE employees");
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
