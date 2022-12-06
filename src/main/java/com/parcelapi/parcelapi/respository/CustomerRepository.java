package com.parcelapi.parcelapi.respository;

import com.parcelapi.parcelapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}

