package com.pablofranca.webservicesmongo.config;

import com.pablofranca.webservicesmongo.domain.Post;
import com.pablofranca.webservicesmongo.domain.User;
import com.pablofranca.webservicesmongo.dto.AuthorDTO;
import com.pablofranca.webservicesmongo.repositories.PostRepository;
import com.pablofranca.webservicesmongo.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    private UserRepository userRepository;
    private PostRepository postRepository;

    public Instantiation(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();
        SimpleDateFormat sdf = new SimpleDateFormat("2018-");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post postMaria = new Post(null, LocalDate.parse("2026-03-21"), "Partiu viagem", "Vou viajar para São Paulo, abraços!", new AuthorDTO(maria));

        postRepository.save(postMaria);
    }
}
