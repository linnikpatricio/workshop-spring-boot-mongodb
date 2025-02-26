package com.linnik.workshopmongo.services;

import com.linnik.workshopmongo.domain.Post;

import com.linnik.workshopmongo.repository.PostRepository;

import com.linnik.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Id não encontrado!"));

    }

}
