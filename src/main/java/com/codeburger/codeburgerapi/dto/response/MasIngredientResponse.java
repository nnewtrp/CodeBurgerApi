package com.codeburger.codeburgerapi.dto.response;

public class MasIngredientResponse {
    private String name;
    private Double price;

    public MasIngredientResponse() {}

    public MasIngredientResponse(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
