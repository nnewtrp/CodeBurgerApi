package com.codeburger.codeburgerapi.dto.response;

import com.codeburger.codeburgerapi.entity.MasMenuIngredients;

import java.util.List;

public class MasMenuHeaderResponse {
    private String name;
    private Double totalPrice;

    public MasMenuHeaderResponse() {}

    public MasMenuHeaderResponse(String name, Double totalPrice) {
        this.name = name;
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }
}
