package com.codeburger.codeburgerapi.repository;

import com.codeburger.codeburgerapi.entity.MasIngredient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MasIngredientRepository extends MongoRepository<MasIngredient, String> {

    Optional<MasIngredient> findByName(String name);

    List<MasIngredient> findByCategory(String category);

}
