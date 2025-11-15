package org.summer2025.ruslan.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public static void insertStmt(Connection connection, String name, int age, String position, float salary) throws SQLException {
        String insertSQL = "INSERT INTO employees (name, age, position, salary) VALUES (?, ?, ?, ?)";
        PreparedStatement preStmt = connection.prepareStatement(insertSQL);
        preStmt.setString(1, name);
        preStmt.setInt(2, age);
        preStmt.setString(3, position);
        preStmt.setFloat(4, salary);

       int rowsInsert= preStmt.executeUpdate();
        System.out.println("Rows inserted: " + rowsInsert);
    }

    public static void updateStmt(Connection connection, String name, int age, String position, float salary) throws SQLException {
        String updateSQL = "UPDATE employees SET name=?, age=?, position=?, salary=?  WHERE id=5";
        PreparedStatement preStmt = connection.prepareStatement(updateSQL);
        preStmt.setString(1, name);
        preStmt.setInt(2, age);
        preStmt.setString(3, position);
        preStmt.setFloat(4, salary);

        int rowsInsert= preStmt.executeUpdate();
        if (rowsInsert==1) {
            System.out.println("Row update");
        } else {
            System.out.println("Update failed");
        }
    }

    public static ResultSet findByIdStmt (Connection connection, int id) throws SQLException {
        String findSQL = "SELECT * FROM employees WHERE id=?";
        PreparedStatement preStmt = connection.prepareStatement(findSQL);
        preStmt.setInt(1,id);
        ResultSet rs = preStmt.executeQuery();
        return rs;
    }

    public static ResultSet findAllStmt(Connection connection) throws SQLException {
        String findAllSQL = "SELECT * FROM employees";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(findAllSQL);
        return rs;
    }

    public static void deleteByIdStmt(Connection connection, int id) throws SQLException {
        String deleteByIdSQL = "DELETE FROM employees WHERE id = ?";
        PreparedStatement preStmt = connection.prepareStatement(deleteByIdSQL);
        preStmt.setInt(1, id);
        int rowDelete = preStmt.executeUpdate();
        if (rowDelete==1) {
            System.out.println("Row delete");
        } else {
            System.out.println("Delete failed");
        }
    }




    public static void printInfo(ResultSet rs) throws SQLException {
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String position = rs.getString("position");
            float salary = rs.getFloat("salary");

            System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Position: " + position + ", Salary: " + salary);
        }
        System.out.println("-------------");
    }
}
