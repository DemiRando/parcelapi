package com.parcelapi.parcelapi.service;

import com.parcelapi.parcelapi.entity.CustomerAddress;
import com.parcelapi.parcelapi.respository.CustomerAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerAddressService {
    @Autowired
    private CustomerAddressRepository repository;

    public CustomerAddress saveCustomerAddress(CustomerAddress customerAddress) {
        return repository.save(customerAddress);
    }

    public List<CustomerAddress> saveCustomerAddress(List<CustomerAddress> customerAddresses) {
        return repository.saveAll(customerAddresses);
    }

    public CustomerAddress getCustomerAddressById(int CustomerID) {
        return repository.findById(CustomerID).orElse(null);
    }


    public CustomerAddress updateCustomerAddress(CustomerAddress customerAddress) {
        CustomerAddress existingCustomerAddress = repository.findById(customerAddress.getCustomerID()).orElse(null);
        return repository.save(existingCustomerAddress);
    }
}
