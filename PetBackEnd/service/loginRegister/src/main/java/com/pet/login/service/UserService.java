package com.pet.login.service;

import com.pet.login.repository.UserRepository;
import com.pet.models.InstitutionWorker;
import com.pet.models.Test;
import com.pet.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository user;

    public User getById(String userID)
    {
        Optional<User> u=user.findById(userID);
        return u.orElse(null);
    }

    public void create(User u){
        user.save(u);
    }
}
