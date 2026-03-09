package com.codeburger.codeburgerapi.controller;

import com.codeburger.codeburgerapi.dto.response.*;
import com.codeburger.codeburgerapi.entity.MasIngredient;
import com.codeburger.codeburgerapi.entity.Order;
import com.codeburger.codeburgerapi.service.OrderService;
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
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping()
    public ResponseEntity<?> getOrderList() {
        List<Order> query = orderService.retrieve();
        List<OrderResponse> data = query.stream().map(
                i -> new OrderResponse(
                        i.getCustomerName(), i.getMenus(), i.getTotalPrice(), i.getCreateDate()
                )
        ).toList();
        Integer totalItems = query.size();
        return ResponseEntity.ok(new DataResponse<>(totalItems, data));
    }

    @GetMapping("/{customerName}")
    public ResponseEntity<?> getOrderInfo(@PathVariable String customerName) {
        Optional<Order> data = orderService.retrieveInfoByCustomer(customerName);
        if (data.isEmpty()) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Data NotFound"));
        }
        return ResponseEntity.ok(new DataInfoResponse<>(data));
    }
}
