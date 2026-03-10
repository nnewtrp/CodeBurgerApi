package com.codeburger.codeburgerapi.controller;

import com.codeburger.codeburgerapi.dto.request.OrderMenusRequest;
import com.codeburger.codeburgerapi.dto.request.OrderRequest;
import com.codeburger.codeburgerapi.dto.response.*;
import com.codeburger.codeburgerapi.entity.Order;
import com.codeburger.codeburgerapi.entity.OrderMenus;
import com.codeburger.codeburgerapi.service.MasMenuService;
import com.codeburger.codeburgerapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    public ResponseEntity<?> getOrderList(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int pageSize) {
        Page<Order> query = orderService.retrieve(page, pageSize);
        List<OrderHeaderResponse> data = query.stream().map(
                i -> new OrderHeaderResponse(
                        i.getCustomerName(), i.getTotalPrice(), i.getCreateDate()
                )
        ).toList();
        Integer totalItems = orderService.retrieveCount();
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
            return ResponseEntity.badRequest().body(new ErrorResponse("Duplicate Customer"));
        }

        List<MasMenuDetailResponse> menuQuery = masMenuService.retrieve();
        Map<String, Double> menuPrice = menuQuery.stream().collect(
                Collectors.toMap(MasMenuDetailResponse::getName, MasMenuDetailResponse::getTotalPrice)
        );

        double totalPrice = 0;
        List<OrderMenus> menus = new ArrayList<>();

        for (OrderMenusRequest menusRequest: request.getMenus()) {
            String menuName = menusRequest.getName();
            if (!menuPrice.containsKey(menuName)) {
                return ResponseEntity.badRequest().body(new ErrorResponse("Menu NotFound - " + menuName));
            }

            double pricePerUnit = menuPrice.get(menuName);
            int amount = menusRequest.getAmount();
            totalPrice += pricePerUnit * amount;

            menus.add(new OrderMenus(menuName, pricePerUnit, amount));
        }

        LocalDateTime createDate = LocalDateTime.now();

        Order data = new Order(request.getCustomerName(), menus, totalPrice, createDate);
        orderService.create(data);

        return ResponseEntity.ok(new DataInfoResponse<>(data));
    }

    @DeleteMapping("/{customerName}")
    public ResponseEntity<?> deleteOrder(@PathVariable String customerName) {
        Optional<Order> data = orderService.retrieveInfoByCustomer(customerName);
        if (data.isEmpty()) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Data NotFound"));
        }

        orderService.delete(data.get());

        return ResponseEntity.ok(new DataInfoResponse<>(data));
    }
}
