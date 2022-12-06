package com.parcelapi.parcelapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
    @Table(name = "[Order]")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private int OrderId;
    private int CustomerID;
    private int RecipientID;
    private int OrderNumber;
    private String OrderDate;
    private String ExpectedDeliveryDate;
    private String DeliveryInstructions;
    private int cost;
    private Date UpdateDate;
    @CreationTimestamp
    @Column(name = "[CreateDate]")
    private Date CreateDate;
    private int Status;
    private int PickupAddressID;
    private String ExpectedPickUpDate;
    private String ParcelSizeRangeID;
    private int OrderRecipientUnreachableID;
    private Integer PaidFromClient;
    private Integer PaidFromServer;
    private Integer PaymentMethodID;

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public int getRecipientID() {
        return RecipientID;
    }

    public void setRecipientID(int recipientID) {
        RecipientID = recipientID;
    }

    public int getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        OrderNumber = orderNumber;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public String getExpectedDeliveryDate() {
        return ExpectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(String expectedDeliveryDate) {
        ExpectedDeliveryDate = expectedDeliveryDate;
    }

    public String getDeliveryInstructions() {
        return DeliveryInstructions;
    }

    public void setDeliveryInstructions(String deliveryInstructions) {
        DeliveryInstructions = deliveryInstructions;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Date getUpdateDate() {
        return UpdateDate;
    }


    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public int getPickupAddressID() {
        return PickupAddressID;
    }

    public void setPickupAddressID(int pickupAddressID) {
        PickupAddressID = pickupAddressID;
    }

    public String getExpectedPickUpDate() {
        return ExpectedPickUpDate;
    }

    public void setExpectedPickUpDate(String expectedPickUpDate) {
        ExpectedPickUpDate = expectedPickUpDate;
    }

    public String getParcelSizeRangeID() {
        return ParcelSizeRangeID;
    }

    public void setParcelSizeRangeID(String parcelSizeRangeID) {
        ParcelSizeRangeID = parcelSizeRangeID;
    }

    public int getOrderRecipientUnreachableID() {
        return OrderRecipientUnreachableID;
    }

    public void setOrderRecipientUnreachableID(int orderRecipientUnreachableID) {
        OrderRecipientUnreachableID = orderRecipientUnreachableID;
    }

    public void setUpdateDate(Date updateDate) {
        UpdateDate = updateDate;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }

    public Integer getPaidFromClient() {
        return PaidFromClient;
    }

    public void setPaidFromClient(Integer paidFromClient) {
        PaidFromClient = paidFromClient;
    }

    public Integer getPaidFromServer() {
        return PaidFromServer;
    }

    public void setPaidFromServer(Integer paidFromServer) {
        PaidFromServer = paidFromServer;
    }

    public Integer getPaymentMethodID() {
        return PaymentMethodID;
    }

    public void setPaymentMethodID(Integer paymentMethodID) {
        PaymentMethodID = paymentMethodID;
    }
}