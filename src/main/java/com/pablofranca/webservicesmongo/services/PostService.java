package com.pablofranca.webservicesmongo.services;

import com.pablofranca.webservicesmongo.domain.Post;
import com.pablofranca.webservicesmongo.repositories.PostRepository;
import com.pablofranca.webservicesmongo.services.exception.IdNotFoundException;
import com.pablofranca.webservicesmongo.services.exception.ObjectNotFoundException;
import com.pablofranca.webservicesmongo.services.exception.PostNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAllPosts () {
        return postRepository.findAll();
    }

    public Optional<Post> findById (String id) {
        return Optional.of(postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("No post found with id " + id)));
    }
}
