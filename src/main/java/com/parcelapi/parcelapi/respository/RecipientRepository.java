package com.parcelapi.parcelapi.respository;

import com.parcelapi.parcelapi.entity.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipientRepository extends JpaRepository<Recipient,Integer> {

}

