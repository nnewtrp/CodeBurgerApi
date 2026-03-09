package com.codeburger.codeburgerapi.controller;

import com.codeburger.codeburgerapi.dto.request.OrderRequest;
import com.codeburger.codeburgerapi.dto.response.*;
import com.codeburger.codeburgerapi.entity.Order;
import com.codeburger.codeburgerapi.entity.OrderMenus;
import com.codeburger.codeburgerapi.service.MasMenuService;
import com.codeburger.codeburgerapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private MasMenuService masMenuService;

    @GetMapping()
    public ResponseEntity<?> getOrderList() {
        List<Order> query = orderService.retrieve();
        List<OrderHeaderResponse> data = query.stream().map(
                i -> new OrderHeaderResponse(
                        i.getCustomerName(), i.getTotalPrice(), i.getCreateDate()
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

    @PostMapping()
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest request) {
        Optional<Order> existingData = orderService.retrieveInfoByCustomer(request.getCustomerName());
        if (existingData.isPresent()) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Duplicate Data"));
        }

        List<MasMenuDetailResponse> menuQuery = masMenuService.retrieve();
        Map<String, Double> menuPrice = menuQuery.stream().collect(
                Collectors.toMap(MasMenuDetailResponse::getName, MasMenuDetailResponse::getTotalPrice)
        );

        double totalPrice = 0;

        for (OrderMenus menus: request.getMenus()) {
            String menuName = menus.getName();
            if (!menuPrice.containsKey(menuName)) {
                return ResponseEntity.badRequest().body(new ErrorResponse("Menu NotFound - " + menuName));
            }
            totalPrice += menuPrice.get(menuName) * menus.getAmount();
        }

        LocalDateTime createDate = LocalDateTime.now();

        Order data = new Order(request.getCustomerName(), request.getMenus(), totalPrice, createDate);
        orderService.create(data);

        return ResponseEntity.ok(new DataInfoResponse<>(data));
    }
}
