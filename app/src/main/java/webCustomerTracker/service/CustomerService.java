package webCustomerTracker.service;

import java.util.List;

import webCustomerTracker.entity.Customer;

public interface CustomerService {
    
    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);

    List<Customer> searchCustomer(String searchName);
}
