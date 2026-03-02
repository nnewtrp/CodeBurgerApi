package com.codeburger.codeburgerapi.controller;

import com.codeburger.codeburgerapi.dto.response.*;
import com.codeburger.codeburgerapi.service.MasMenuService;
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
@RequestMapping("master/menu")
public class MasMenuController {
    @Autowired
    private MasMenuService masMenuService;

    @GetMapping()
    public ResponseEntity<?> getMenuList() {
        List<MasMenuDetailResponse> query = masMenuService.retrieve();
        Map<String, List<MasMenuHeaderResponse>> data = query.stream()
                .collect(groupingBy(
                        MasMenuDetailResponse::getCategory,
                        mapping(i -> new MasMenuHeaderResponse(i.getName(), i.getTotalPrice()), toList()
                ))
        );
        Integer totalItems = query.toArray().length;
        return ResponseEntity.ok(new DataResponse<>(totalItems, data));
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getMenuInfo(@PathVariable String name) {
        Optional<MasMenuDetailResponse> data = masMenuService.retrieveInfo(name);
        if (data.isEmpty()) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Data NotFound"));
        }
        return ResponseEntity.ok(new DataInfoResponse<>(data));
    }

    @GetMapping("/category/{categoryName}")
    public ResponseEntity<?> getMenuListByCategory(@PathVariable String categoryName) {
        List<MasMenuDetailResponse> query = masMenuService.retrieveByCategory(categoryName);
        if (query.isEmpty()) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Data NotFound"));
        }
        List<MasMenuHeaderResponse> data = query.stream().map(
                i -> new MasMenuHeaderResponse(i.getName(), i.getTotalPrice())
        ).toList();
        Integer totalItems = query.toArray().length;
        return ResponseEntity.ok(new DataResponse<>(totalItems, data));
    }
}
