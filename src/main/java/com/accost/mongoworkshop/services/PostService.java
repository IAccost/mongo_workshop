package com.accost.mongoworkshop.services;

import com.accost.mongoworkshop.domain.Post;
import com.accost.mongoworkshop.domain.User;
import com.accost.mongoworkshop.dto.UserDTO;
import com.accost.mongoworkshop.repository.PostRepository;
import com.accost.mongoworkshop.repository.UserRepository;
import com.accost.mongoworkshop.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }
    public List<Post> findByTitle(String text) {
        return repo.findByTitleContainingIgnoreCase(text);
    }
}