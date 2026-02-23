package com.codeburger.codeburgerapi.service;

import com.codeburger.codeburgerapi.entity.MasIngredient;
import com.codeburger.codeburgerapi.repository.MasIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasIngredientService {
    private final MasIngredientRepository repository;

    @Autowired
    public MasIngredientService(MasIngredientRepository repository) {
        this.repository = repository;
    }

    public List<MasIngredient> retrieveIngredients() {
        return repository.findAll();
    }

}
