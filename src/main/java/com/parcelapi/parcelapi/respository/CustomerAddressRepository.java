package com.parcelapi.parcelapi.respository;

import com.parcelapi.parcelapi.entity.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddress,Integer> {

}

