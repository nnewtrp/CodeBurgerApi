package com.codeburger.codeburgerapi.controller;

import com.codeburger.codeburgerapi.entity.MasIngredient;
import com.codeburger.codeburgerapi.service.MasIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("master/ingredient")
public class MasIngredientController {
    @Autowired
    private MasIngredientService masIngredientService;

    @GetMapping()
    public ResponseEntity<?> getIngredients() {
        List<MasIngredient> data = masIngredientService.retrieveIngredients();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getIngredientInfo(@PathVariable String name) {
        Optional<MasIngredient> existingData = masIngredientService.retrieveIngredientInfo(name);
        if (existingData.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(existingData);
    }

    @GetMapping("/category/{categoryName}")
    public ResponseEntity<?> getIngredientByCategory(@PathVariable String categoryName) {
        List<MasIngredient> data = masIngredientService.retrieveIngredientsByCategory(categoryName);
        if (data.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(data);
    }
}
