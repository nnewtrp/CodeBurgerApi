package com.codeburger.codeburgerapi.dto.request;

import com.codeburger.codeburgerapi.entity.OrderMenus;

import java.time.LocalDateTime;
import java.util.List;

public class OrderRequest {
    private String customerName;
    private List<OrderMenus> menus;

    public OrderRequest() {}

    public OrderRequest(String customerName, List<OrderMenus> menus) {
        this.customerName = customerName;
        this.menus = menus;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<OrderMenus> getMenus() {
        return menus;
    }
}
