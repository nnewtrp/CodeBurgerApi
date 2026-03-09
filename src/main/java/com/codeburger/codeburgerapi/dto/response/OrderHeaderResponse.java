package com.codeburger.codeburgerapi.dto.response;

import com.codeburger.codeburgerapi.entity.OrderMenus;

import java.time.LocalDateTime;
import java.util.List;

public class OrderHeaderResponse {
    private String customerName;
    private Double totalPrice;
    private LocalDateTime createDate;

    public OrderHeaderResponse() {}

    public OrderHeaderResponse(String customerName, Double totalPrice, LocalDateTime createDate) {
        this.customerName = customerName;
        this.totalPrice = totalPrice;
        this.createDate = createDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }
}
