package org.summer2025.ruslan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class ConnectionManager {
    private static final String URL_KEY = "db.url";
    private static final String USER_KEY = "db.user";
    private static final String PASSWORD_KEY = "db.password";
    private static Connection connection;


    static {
        loadDriver();
    }

    private ConnectionManager() {
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
                    ConfigLoad.getValue(URL_KEY),
                    ConfigLoad.getValue(USER_KEY),
                    ConfigLoad.getValue(PASSWORD_KEY)
            );
            System.out.println("Connection to DB...");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        return connection;

    }

    public static void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

