package com.parcelapi.parcelapi.respository;

import com.parcelapi.parcelapi.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {

}

