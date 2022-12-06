package com.parcelapi.parcelapi.service;

import com.parcelapi.parcelapi.entity.Recipient;
import com.parcelapi.parcelapi.respository.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipientService {
    @Autowired
    private RecipientRepository repository;

    public Recipient saveRecipient(Recipient recipient) {
        return repository.save(recipient);
    }

    public List<Recipient> saveRecipients(List<Recipient> recipients) {
        return repository.saveAll(recipients);
    }

    public Recipient getRecipientById(int RecipientID) {
        return repository.findById(RecipientID).orElse(null);
    }


    public Recipient updateRecipient(Recipient recipient) {
        Recipient existingRecipient = repository.findById(recipient.getRecipientID()).orElse(null);
        return repository.save(existingRecipient);
    }
}

