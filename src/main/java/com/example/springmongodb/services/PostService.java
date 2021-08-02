package com.example.springmongodb.services;

import com.example.springmongodb.domain.Post;
import com.example.springmongodb.repositories.PostRepository;
import com.example.springmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findByID(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Post not found. ID: " + id + "."));
    }
}
