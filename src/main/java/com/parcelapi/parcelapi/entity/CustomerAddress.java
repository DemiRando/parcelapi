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
    @Table(name = "[CustomerAddress]")
public class CustomerAddress {

    @Id
    private int CustomerID;
    private int AddressID;
    private Date ValidTo;
    private int IsCurrent;
    private Date UpdateDate;
    @CreationTimestamp
    @Column(name = "[CreateDate]")
    private Date CreateDate;

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public int getAddressID() {
        return AddressID;
    }

    public void setAddressID(int addressID) {
        AddressID = addressID;
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

    public Date getUpdateDate() {
        return UpdateDate;
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
}