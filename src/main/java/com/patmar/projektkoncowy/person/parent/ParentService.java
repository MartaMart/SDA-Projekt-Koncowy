package com.patmar.projektkoncowy.person.parent;

import org.springframework.stereotype.Service;

@Service
public class ParentService {

    private ParentRepository repository;

    public ParentService(ParentRepository repository) {
        this.repository = repository;
    }

    public Parent getParentById(Long id) {
        return repository.findById(id).orElseThrow(ParentNotFoundException::new);
    }
}
