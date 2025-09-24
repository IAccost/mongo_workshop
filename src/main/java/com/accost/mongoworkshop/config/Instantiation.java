package com.accost.mongoworkshop.config;

import com.accost.mongoworkshop.domain.Post;
import com.accost.mongoworkshop.domain.User;
import com.accost.mongoworkshop.dto.AuthorDTO;
import com.accost.mongoworkshop.repository.PostRepository;
import com.accost.mongoworkshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository repo;

    @Autowired
    private PostRepository postRepo;
    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT"));

        repo.deleteAll();
        postRepo.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        repo.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, "21/03/2018", "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, "23/03/2018", "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        postRepo.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        repo.save(maria);
    }

}
