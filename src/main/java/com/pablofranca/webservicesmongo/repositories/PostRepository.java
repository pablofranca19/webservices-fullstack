package com.pablofranca.webservicesmongo.repositories;

import com.pablofranca.webservicesmongo.domain.Post;
import com.pablofranca.webservicesmongo.domain.User;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findPostsByTitleIgnoreCase(String title);

}
