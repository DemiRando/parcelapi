package com.parcelapi.parcelapi.service;

import com.parcelapi.parcelapi.entity.Address;
import com.parcelapi.parcelapi.respository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository repository;

    public Address saveAddress(Address address) {
        return repository.save(address);
    }

    public List<Address> saveAddress(List<Address> addresses) {
        return repository.saveAll(addresses);
    }

    public Address getAddressById(int AddressID) {
        return repository.findById(AddressID).orElse(null);
    }


    public Address updateAddress(Address address) {
        Address existingAddress = repository.findById(address.getAddressID()).orElse(null);
        return repository.save(existingAddress);
    }
}
