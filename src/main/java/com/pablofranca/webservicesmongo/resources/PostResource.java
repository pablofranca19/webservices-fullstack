package com.pablofranca.webservicesmongo.resources;

import com.pablofranca.webservicesmongo.domain.Post;
import com.pablofranca.webservicesmongo.services.PostService;
import com.pablofranca.webservicesmongo.services.exception.PostNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostResource {

    private PostService postService;

    public PostResource(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts () {
        List<Post> postList = postService.findAllPosts();
        return ResponseEntity.ok(postList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Post>> findPostById (@PathVariable String id) {
        Optional<Post> post = Optional.of(postService.findById(id).orElseThrow(() -> new PostNotFoundException("Post not found with id " + id)));
        return ResponseEntity.ok(post);
     }

}
