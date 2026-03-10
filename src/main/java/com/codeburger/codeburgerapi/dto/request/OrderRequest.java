package com.codeburger.codeburgerapi.dto.request;

import com.codeburger.codeburgerapi.entity.OrderMenus;

import java.time.LocalDateTime;
import java.util.List;

public class OrderRequest {
    private String customerName;
    private List<OrderMenusRequest> menus;

    public OrderRequest() {}

    public OrderRequest(String customerName, List<OrderMenusRequest> menus) {
        this.customerName = customerName;
        this.menus = menus;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<OrderMenusRequest> getMenus() {
        return menus;
    }
}
