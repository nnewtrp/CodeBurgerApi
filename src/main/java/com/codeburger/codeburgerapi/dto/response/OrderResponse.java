package com.codeburger.codeburgerapi.dto.response;

import com.codeburger.codeburgerapi.entity.OrderMenus;

import java.time.LocalDateTime;
import java.util.List;

public class OrderResponse {
    private String customerName;
    private List<OrderMenus> menus;
    private Double totalPrice;
    private LocalDateTime createDate;

    public OrderResponse() {}

    public OrderResponse(String customerName, List<OrderMenus> menus, Double totalPrice, LocalDateTime createDate) {
        this.customerName = customerName;
        this.menus = menus;
        this.totalPrice = totalPrice;
        this.createDate = createDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<OrderMenus> getMenus() {
        return menus;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }
}
