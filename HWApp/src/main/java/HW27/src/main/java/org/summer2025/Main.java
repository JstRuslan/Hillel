package org.summer2025;

import org.summer2025.util.ConnectionManager;

import java.sql.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("### Create table IF NOT EXISTS ###");
        System.out.println("### INSERT VALUES INTO users (name, age, email) ###");

        String selectSQL = "SELECT * FROM users";
        String deleteSQL = "DELETE FROM users WHERE name=?";

        try (Connection connection = ConnectionManager.getConnection()) {
            selectStmt(connection, selectSQL);
            deleteStmt(connection, deleteSQL);
            System.out.println("---Update tabble---");
            selectStmt(connection, selectSQL);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void deleteStmt(Connection connection, String deleteSQL) throws SQLException {
        PreparedStatement preStmt = connection.prepareStatement(deleteSQL);
        preStmt.setString(1, "Bob");
        int result = preStmt.executeUpdate();
        if (result > 0) {
            System.out.println("Records were delete - " + result);
        }
    }

    private static void selectStmt(Connection connection, String selectSQL) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(selectSQL);
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String email = rs.getString("email");

            System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Email: " + email);
        }
    }
}
