package webCustomerTracker.dao;

import java.util.List;

import webCustomerTracker.entity.Customer;;

public interface CustomerDAO {
    List<Customer> getCustomers();
}
