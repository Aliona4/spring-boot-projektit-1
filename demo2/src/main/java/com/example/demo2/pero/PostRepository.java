package com.example.demo2.pero;

import org.springframework.data.repository.CrudRepository;

import com.example.demo2.models.Post;

public interface PostRepository extends CrudRepository<Post, Long> {

    // void save(com.example.demo2.controllers.Post post);

}