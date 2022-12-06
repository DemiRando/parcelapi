package com.parcelapi.parcelapi.service;

import com.parcelapi.parcelapi.entity.Customer;
import com.parcelapi.parcelapi.respository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    public List<Customer> saveCustomers(List<Customer> customers) {
        return repository.saveAll(customers);
    }

    public Customer getCustomerById(int CustomerID) {
        return repository.findById(CustomerID).orElse(null);
    }

    public List<Customer> getCustomers() {
        return repository.findAll();
    }

    public Customer updateCustomer(Customer customer) {
        Customer existingCustomer = repository.findById(customer.getCustomerID()).orElse(null);
        return repository.save(existingCustomer);
    }
}
