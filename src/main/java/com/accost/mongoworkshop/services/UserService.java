package com.accost.mongoworkshop.services;

import com.accost.mongoworkshop.domain.User;
import com.accost.mongoworkshop.repository.UserRepository;
import com.accost.mongoworkshop.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }
    public User findById(String id) {
        User user = repo.findById(id).orElse(null);
//        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found"));
        if (user == null) {
            throw new ObjectNotFoundException("User not found");
        }
        return user;
    }
}