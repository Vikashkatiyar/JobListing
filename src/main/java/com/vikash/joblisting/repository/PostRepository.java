package com.vikash.joblisting.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vikash.joblisting.model.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
