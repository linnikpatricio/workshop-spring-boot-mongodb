package com.linnik.workshopmongo.services;

import com.linnik.workshopmongo.domain.Post;

import com.linnik.workshopmongo.repository.PostRepository;

import com.linnik.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Id não encontrado!"));

    }
    public List<Post> findByTitle(String text) {
        return repository.serachTitle(text);
    }
    public List<Post> fullSearch(String text, Date dataMin, Date dataMax) {
        dataMax = new Date(dataMax.getTime() + 24 * 60 * 60 * 1000);
        return repository.fullSearch(text, dataMin, dataMax);
    }

}
