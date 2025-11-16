package org.summer2025.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDAO {

   void selectStmt(Connection connection, String selectSQL) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(selectSQL);
        printInfo(rs);

    }

   private void printInfo(ResultSet rs) throws SQLException {
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String email = rs.getString("email");

            System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Email: " + email);
        }
    }
}
