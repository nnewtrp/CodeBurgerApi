package com.codeburger.codeburgerapi.entity;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "order")
public class Order {
    @Id
    private String id;
    @NotNull
    private String customerName;
    @NotNull
    private List<OrderMenus> menus;
    @NotNull
    private LocalDateTime createDate;

    public Order() {}

    public Order(String customerName, List<OrderMenus> menus, LocalDateTime createDate) {
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
