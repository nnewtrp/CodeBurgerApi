package com.codeburger.codeburgerapi.controller;

import com.codeburger.codeburgerapi.entity.MasIngredient;
import com.codeburger.codeburgerapi.service.MasIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("master/ingredient")
public class MasIngredientController {
    @Autowired
    private MasIngredientService masIngredientService;

    @GetMapping()
    public ResponseEntity<?> getIngredients() {
        List<MasIngredient> masIngredients = masIngredientService.retrieveIngredients();
        return ResponseEntity.ok(masIngredients);
    }
}
