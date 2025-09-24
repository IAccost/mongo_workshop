package com.accost.mongoworkshop.services;

import com.accost.mongoworkshop.domain.User;
import com.accost.mongoworkshop.dto.UserDTO;
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
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }
    public User insert(User obj) {
        return repo.insert(obj);
    }
    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }
}