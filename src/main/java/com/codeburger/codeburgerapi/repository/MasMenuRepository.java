package com.codeburger.codeburgerapi.repository;

import com.codeburger.codeburgerapi.entity.MasMenu;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MasMenuRepository extends MongoRepository<MasMenu, String> {
    Optional<MasMenu> findByName(String name);
    List<MasMenu> findByCategory(String category);
}
