package com.pablofranca.webservicesmongo.resources;

import com.pablofranca.webservicesmongo.domain.Post;
import com.pablofranca.webservicesmongo.resources.util.URL;
import com.pablofranca.webservicesmongo.services.PostService;
import com.pablofranca.webservicesmongo.services.exception.PostNotFoundException;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findPostByTitle (@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeTo(text);
        List<Post> list = postService.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

}
