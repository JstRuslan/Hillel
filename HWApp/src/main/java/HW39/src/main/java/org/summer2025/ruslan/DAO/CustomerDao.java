package org.summer2025.ruslan.DAO;

import org.summer2025.ruslan.entity.Customer;
import java.util.List;

public interface CustomerDao {
    // CREATE
    public void addCustomer(Customer customer);

    // READ by ID
    public Customer getCustomerById(int id);

    // READ all
    public List<Customer> getAllCustomers();

    // UPDATE
    public void updateCustomer(Customer customer);

    // DELETE
    public void deleteCustomer(int id);
}
