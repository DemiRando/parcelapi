package com.parcelapi.parcelapi.service;

import com.parcelapi.parcelapi.entity.User;
import com.parcelapi.parcelapi.exceptions.EtAuthException;
import com.parcelapi.parcelapi.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.parcelapi.parcelapi.controller.ProductController;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        return repository.save(user);
    }

    public User getUserById(int userId) {
        return repository.findById(userId).orElse(null);
    }

    public Boolean registerUser(String firstName, String lastName, String email, String password) throws EtAuthException {
       User user = new User();
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if(email != null) email = email.toLowerCase();
        if(!pattern.matcher(email).matches())
            throw new EtAuthException("Invalid email format");
        Integer count = repository.getCountByEmail(email);
        if(count > 0)
            throw new EtAuthException("Email already in use");

        return true;
    }

    public User validateUser(String email,String password)throws EtAuthException{
        if(email != null) email = email.toLowerCase();
        return repository.findByEmailAndPassword(email, password);

        }
    public User updateUser(User user) {
        User existingUser = repository.findById(user.getUserId()).orElse(null);
        return repository.save(existingUser);
    }
}
