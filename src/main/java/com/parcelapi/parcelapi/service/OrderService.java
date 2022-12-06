package com.parcelapi.parcelapi.service;

import com.parcelapi.parcelapi.entity.Order;
import com.parcelapi.parcelapi.respository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public Order saveOrder(Order order) {
        return repository.save(order);
    }

    public List<Order> saveOrders(List<Order> orders) {
        return repository.saveAll(orders);
    }

    public Order getOrderById(int OrderId) {
        return repository.findById(OrderId).orElse(null);
    }

    public String deleteOrder(int OrderId) {
        repository.deleteById(OrderId);
        return "order removed !! " + OrderId;
    }
    public Order updateOrder(Order order) {
        Order existingOrder = repository.findById(order.getOrderId()).orElse(null);
        return repository.save(existingOrder);
    }
}
