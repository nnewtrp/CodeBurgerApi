package com.codeburger.codeburgerapi.controller;

import com.codeburger.codeburgerapi.entity.Order;
import com.codeburger.codeburgerapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping()
    public ResponseEntity<?> getMenuList() {
        List<Order> query = orderService.retrieve();
        return ResponseEntity.ok(query);
    }
}
