package com.codeburger.codeburgerapi.dto.response;

import com.codeburger.codeburgerapi.entity.MasMenuIngredients;

import java.util.List;

public class MasMenuHeaderResponse {
    private String name;
    private String category;
    private Double totalPrice;

    public MasMenuHeaderResponse() {}

    public MasMenuHeaderResponse(String name, String category, Double totalPrice) {
        this.name = name;
        this.category = category;
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }
}
