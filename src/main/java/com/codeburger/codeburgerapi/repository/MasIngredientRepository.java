package com.codeburger.codeburgerapi.repository;

import com.codeburger.codeburgerapi.entity.MasIngredient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MasIngredientRepository extends MongoRepository<MasIngredient, String> {
    List<MasIngredient> findByName(String name);
}
