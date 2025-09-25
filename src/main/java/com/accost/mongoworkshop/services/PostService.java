package com.accost.mongoworkshop.services;

import com.accost.mongoworkshop.domain.Post;
import com.accost.mongoworkshop.domain.User;
import com.accost.mongoworkshop.dto.UserDTO;
import com.accost.mongoworkshop.repository.PostRepository;
import com.accost.mongoworkshop.repository.UserRepository;
import com.accost.mongoworkshop.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }
    public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }
    public List<Post> fullSearch(String text, Date minDate,Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repo.fullSearch(text, minDate, maxDate);
    }
}