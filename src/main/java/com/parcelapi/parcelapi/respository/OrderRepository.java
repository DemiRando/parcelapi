package com.parcelapi.parcelapi.respository;

import com.parcelapi.parcelapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {

}

