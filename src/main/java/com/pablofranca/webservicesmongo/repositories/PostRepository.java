package com.pablofranca.webservicesmongo.repositories;

import com.pablofranca.webservicesmongo.domain.Post;
import com.pablofranca.webservicesmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {


}
