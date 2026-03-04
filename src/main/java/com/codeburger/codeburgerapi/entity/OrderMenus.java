package com.codeburger.codeburgerapi.entity;

public class OrderMenus {
    private String name;
    private Integer amount;

    public OrderMenus() {}

    public OrderMenus(String name, Integer amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public Integer getAmount() {
        return amount;
    }
}
