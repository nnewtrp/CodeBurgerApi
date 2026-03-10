package com.codeburger.codeburgerapi.entity;

public class OrderMenus {
    private String name;
    private Double pricePerUnit;
    private Integer amount;

    public OrderMenus() {}

    public OrderMenus(String name, Double pricePerUnit, Integer amount) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public Integer getAmount() {
        return amount;
    }
}
