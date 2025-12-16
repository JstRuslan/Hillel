package org.summer2025.ruslan.DAO;

import org.springframework.jdbc.core.RowMapper;
import org.summer2025.ruslan.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Customer(
                rs.getInt("id"),
                rs.getString("full_name"),
                rs.getString("email"),
                rs.getString("social_security_number")
        );
    }
}
