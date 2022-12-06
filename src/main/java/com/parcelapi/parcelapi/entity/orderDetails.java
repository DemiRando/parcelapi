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
    @Table
public class orderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int OrderDID;
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
    private String CustomerNumber;
    private String CustomerTitle;
    private String CustomerFirstName;
    private String CustomerLastName;
    private String CustomerPhoneNumber;
    private String CustomerEmail;
    private String CustomerCity;
    private String CustomerCountry;
    private String CustomerAddressline1;
    private String CustomerAddressline2;
    private String CustomerAddressline3;
    private String CustomerPostCode;
    private int AddressID;
    private int AddressTypeID;
    private String AddressLine1;
    private String AddressLine2;
    private String AddressLine3;
    private String City;
    private String Country;
    private String PostCode;
    private float Longitude;
    private float Latitude;
    private int IsDefault;
    private Date ValidTo;
    private int IsCurrent;
    private String RecipientTitle;
    private String RecipientFirstName;
    private String RecipientLastName;
    private String RecipientPhoneNumber;
    private String RecipientEmail;

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

    public String getCustomerNumber() {
        return CustomerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        CustomerNumber = customerNumber;
    }

    public String getCustomerTitle() {
        return CustomerTitle;
    }

    public void setCustomerTitle(String customerTitle) {
        CustomerTitle = customerTitle;
    }

    public String getCustomerFirstName() {
        return CustomerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        CustomerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return CustomerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        CustomerLastName = customerLastName;
    }

    public String getCustomerPhoneNumber() {
        return CustomerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        CustomerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        CustomerEmail = customerEmail;
    }

    public int getAddressID() {
        return AddressID;
    }

    public void setAddressID(int addressID) {
        AddressID = addressID;
    }

    public int getAddressTypeID() {
        return AddressTypeID;
    }

    public void setAddressTypeID(int addressTypeID) {
        AddressTypeID = addressTypeID;
    }

    public String getAddressLine1() {
        return AddressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        AddressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return AddressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        AddressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return AddressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        AddressLine3 = addressLine3;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getPostCode() {
        return PostCode;
    }

    public void setPostCode(String postCode) {
        PostCode = postCode;
    }

    public float getLongitude() {
        return Longitude;
    }

    public void setLongitude(float longitude) {
        Longitude = longitude;
    }

    public float getLatitude() {
        return Latitude;
    }

    public void setLatitude(float latitude) {
        Latitude = latitude;
    }

    public int getIsDefault() {
        return IsDefault;
    }

    public void setIsDefault(int isDefault) {
        IsDefault = isDefault;
    }

    public Date getValidTo() {
        return ValidTo;
    }

    public void setValidTo(Date validTo) {
        ValidTo = validTo;
    }

    public int getIsCurrent() {
        return IsCurrent;
    }

    public void setIsCurrent(int isCurrent) {
        IsCurrent = isCurrent;
    }
    public String getRecipientTitle() {
        return RecipientTitle;
    }

    public void setRecipientTitle(String recipientTitle) {
        RecipientTitle = recipientTitle;
    }

    public String getRecipientFirstName() {
        return RecipientFirstName;
    }

    public void setRecipientFirstName(String recipientFirstName) {
        RecipientFirstName = recipientFirstName;
    }

    public String getRecipientLastName() {
        return RecipientLastName;
    }

    public void setRecipientLastName(String recipientLastName) {
        RecipientLastName = recipientLastName;
    }

    public String getRecipientPhoneNumber() {
        return RecipientPhoneNumber;
    }

    public void setRecipientPhoneNumber(String recipientPhoneNumber) {
        RecipientPhoneNumber = recipientPhoneNumber;
    }

    public String getRecipientEmail() {
        return RecipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        RecipientEmail = recipientEmail;
    }

    public int getOrderDID() {
        return OrderDID;
    }

    public void setOrderDID(int orderDID) {
        OrderDID = orderDID;
    }

    public String getCustomerCity() {
        return CustomerCity;
    }

    public void setCustomerCity(String customerCity) {
        CustomerCity = customerCity;
    }

    public String getCustomerCountry() {
        return CustomerCountry;
    }

    public void setCustomerCountry(String customerCountry) {
        CustomerCountry = customerCountry;
    }

    public String getCustomerAddressline1() {
        return CustomerAddressline1;
    }

    public void setCustomerAddressline1(String customerAddressline1) {
        CustomerAddressline1 = customerAddressline1;
    }

    public String getCustomerAddressline2() {
        return CustomerAddressline2;
    }

    public void setCustomerAddressline2(String customerAddressline2) {
        CustomerAddressline2 = customerAddressline2;
    }

    public String getCustomerAddressline3() {
        return CustomerAddressline3;
    }

    public void setCustomerAddressline3(String customerAddressline3) {
        CustomerAddressline3 = customerAddressline3;
    }

    public String getCustomerPostCode() {
        return CustomerPostCode;
    }

    public void setCustomerPostCode(String customerPostCode) {
        CustomerPostCode = customerPostCode;
    }
}