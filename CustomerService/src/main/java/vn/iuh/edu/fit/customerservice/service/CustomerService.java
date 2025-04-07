package vn.iuh.edu.fit.customerservice.service;

import vn.iuh.edu.fit.customerservice.entity.Customer;

public interface CustomerService {
    Customer getById(Long id);
    Customer create(Customer customer);
}
