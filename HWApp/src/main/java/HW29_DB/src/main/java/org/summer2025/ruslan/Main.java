package org.summer2025.ruslan;

import org.summer2025.ruslan.DAO.EmployeeDAO;
import org.summer2025.ruslan.Utils.DatabaseConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try (Connection connection = DatabaseConnector.getConnection()) {
           EmployeeDAO.insertStmt(connection, "Ivan", 36,"manager", 1900);
           EmployeeDAO.printInfo(EmployeeDAO.findByIdStmt(connection,5));
           EmployeeDAO.updateStmt(connection, "Ivan", 36,"manager", 1850);
           ResultSet rs = EmployeeDAO.findAllStmt(connection);
           EmployeeDAO.printInfo(rs);
           EmployeeDAO.deleteByIdStmt(connection, 5);
           rs = EmployeeDAO.findAllStmt(connection);
           EmployeeDAO.printInfo(rs);


           DatabaseConnector.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
