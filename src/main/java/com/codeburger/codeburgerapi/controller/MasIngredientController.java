package com.codeburger.codeburgerapi.controller;

import com.codeburger.codeburgerapi.dto.response.DataResponse;
import com.codeburger.codeburgerapi.dto.response.ErrorResponse;
import com.codeburger.codeburgerapi.dto.response.MasIngredientResponse;
import com.codeburger.codeburgerapi.entity.MasIngredient;
import com.codeburger.codeburgerapi.service.MasIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.*;

@RestController
@RequestMapping("master/ingredient")
public class MasIngredientController {
    @Autowired
    private MasIngredientService masIngredientService;

    @GetMapping()
    public ResponseEntity<?> getIngredients() {
        List<MasIngredient> query = masIngredientService.retrieveIngredients();
        Map<String, List<MasIngredientResponse>> data = query.stream()
                .collect(groupingBy(
                        MasIngredient::getCategory,
                        mapping(i -> new MasIngredientResponse(i.getName(), i.getPrice()), toList()
                ))
        );
        return ResponseEntity.ok(new DataResponse<>(data));
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getIngredientInfo(@PathVariable String name) {
        Optional<MasIngredient> data = masIngredientService.retrieveIngredientInfo(name);
        if (data.isEmpty()) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Data NotFound"));
        }
        return ResponseEntity.ok(new DataResponse<>(data));
    }

    @GetMapping("/category/{categoryName}")
    public ResponseEntity<?> getIngredientByCategory(@PathVariable String categoryName) {
        List<MasIngredient> query = masIngredientService.retrieveIngredientsByCategory(categoryName);
        if (query.isEmpty()) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Data NotFound"));
        }
        List<MasIngredientResponse> data = query.stream().map(
                i -> new MasIngredientResponse(i.getName(), i.getPrice())
        ).toList();
        return ResponseEntity.ok(new DataResponse<>(data));
    }
}
