package com.codeburger.codeburgerapi.dto.response;

public class MasMenuIngredientsResponse {
    private String name;
    private Integer amount;
    private Double pricePerUnit;

    public MasMenuIngredientsResponse() {}

    public MasMenuIngredientsResponse(String name, Integer amount, Double pricePerUnit) {
        this.name = name;
        this.amount = amount;
        this.pricePerUnit = pricePerUnit;
    }

    public String getName() {
        return name;
    }

    public Integer getAmount() {
        return amount;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }
}
