package com.codeburger.codeburgerapi.dto.response;

import com.codeburger.codeburgerapi.entity.OrderMenus;

import java.time.LocalDateTime;
import java.util.List;

public class OrderResponse {
    private String customerName;
    private List<OrderMenus> menus;
    private LocalDateTime createDate;

    public OrderResponse() {}

    public OrderResponse(String customerName, List<OrderMenus> menus, LocalDateTime createDate) {
        this.customerName = customerName;
        this.menus = menus;
        this.createDate = createDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<OrderMenus> getMenus() {
        return menus;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }
}
