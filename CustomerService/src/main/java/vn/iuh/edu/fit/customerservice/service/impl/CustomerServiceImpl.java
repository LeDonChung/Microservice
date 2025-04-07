package vn.iuh.edu.fit.customerservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.iuh.edu.fit.customerservice.entity.Customer;
import vn.iuh.edu.fit.customerservice.repository.CustomerRepository;
import vn.iuh.edu.fit.customerservice.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer create(Customer customer) {
        customer.setStatus(1);
        return customerRepository.save(customer);
    }
}
