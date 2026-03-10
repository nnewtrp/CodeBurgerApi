package com.codeburger.codeburgerapi.dto.request;

public class OrderMenusRequest {
    private String name;
    private Integer amount;

    public OrderMenusRequest() {}

    public OrderMenusRequest(String name, Integer amount) {
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
