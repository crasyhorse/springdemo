package webCustomerTracker.dao;

import java.util.List;

import webCustomerTracker.entity.Customer;;

public interface CustomerDAO {
    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);

    List<Customer> searchCustomer(String searchName);
}
