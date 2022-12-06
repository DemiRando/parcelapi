package com.parcelapi.parcelapi.service;

import com.parcelapi.parcelapi.entity.orderDetails;
import com.parcelapi.parcelapi.respository.orderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class orderDetailsService {
    @Autowired
    private orderDetailsRepository repository;

    public orderDetails saveOrder(orderDetails orderDetail) {
        return repository.save(orderDetail);
    }

    public List<orderDetails> saveOrders(List<orderDetails> orderDetails) {
        return repository.saveAll(orderDetails);
    }

    public orderDetails getOrderByDID(int OrderDID) {
        return repository.findById(OrderDID).orElse(null);
    }

    public String deleteOrder(int OrderDID) {
        repository.deleteById(OrderDID);
        return "order removed !! " + OrderDID;
    }
    public orderDetails updateOrder(orderDetails orderDetails) {
        orderDetails existingOrder = repository.findById(orderDetails.getOrderDID()).orElse(null);
        existingOrder.setCustomerEmail(orderDetails.getCustomerEmail());
        existingOrder.setCustomerFirstName(orderDetails.getCustomerFirstName());
        existingOrder.setCustomerLastName(orderDetails.getCustomerLastName());
        existingOrder.setCustomerTitle(orderDetails.getCustomerTitle());
        existingOrder.setCustomerPhoneNumber(orderDetails.getCustomerPhoneNumber());
        existingOrder.setRecipientEmail(orderDetails.getRecipientEmail());
        existingOrder.setRecipientFirstName(orderDetails.getRecipientFirstName());
        existingOrder.setRecipientLastName(orderDetails.getRecipientLastName());
        existingOrder.setRecipientTitle(orderDetails.getRecipientTitle());
        existingOrder.setRecipientPhoneNumber(orderDetails.getRecipientPhoneNumber());
        return repository.save(existingOrder);
    }
}
