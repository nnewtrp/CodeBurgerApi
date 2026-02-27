package com.codeburger.codeburgerapi.controller;

import com.codeburger.codeburgerapi.dto.response.DataResponse;
import com.codeburger.codeburgerapi.dto.response.ErrorResponse;
import com.codeburger.codeburgerapi.dto.response.MasMenuDetailResponse;
import com.codeburger.codeburgerapi.entity.MasMenu;
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
        List<MasMenuDetailResponse> data = masMenuService.retrieve();
        return ResponseEntity.ok(new DataResponse<>(data));
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getMenuInfo(@PathVariable String name) {
        Optional<MasMenu> data = masMenuService.retrieveInfo(name);
        if (data.isEmpty()) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Data NotFound"));
        }
        return ResponseEntity.ok(new DataResponse<>(data));
    }
}
