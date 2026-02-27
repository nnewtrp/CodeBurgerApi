package com.codeburger.codeburgerapi.service;

import com.codeburger.codeburgerapi.dto.response.MasMenuDetailResponse;
import com.codeburger.codeburgerapi.entity.MasMenu;
import com.codeburger.codeburgerapi.repository.MasMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MasMenuService {
    private final MasMenuRepository repository;

    @Autowired
    public MasMenuService(MasMenuRepository repository) {
        this.repository = repository;
    }

    public List<MasMenuDetailResponse> retrieve() {
        return repository.findAllDetails();
    }

    public Optional<MasMenu> retrieveInfo(String name) {
        return repository.findByName(name);
    }

    public List<MasMenu> retrieveByCategory(String category) {
        return repository.findByCategory(category);
    }

}
