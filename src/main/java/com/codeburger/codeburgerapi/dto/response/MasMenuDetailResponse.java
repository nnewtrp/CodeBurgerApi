package com.codeburger.codeburgerapi.dto.response;

import com.codeburger.codeburgerapi.dto.response.MasMenuIngredientsResponse;

import java.util.List;

public class MasMenuDetailResponse {
    private String name;
    private String category;
    private List<MasMenuIngredientsResponse> ingredients;
    private Double totalPrice;

    public MasMenuDetailResponse() {}

    public MasMenuDetailResponse(
         String name, String category, List<MasMenuIngredientsResponse> ingredients, Double totalPrice
    ) {
        this.name = name;
        this.category = category;
        this.ingredients = ingredients;
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public List<MasMenuIngredientsResponse> getIngredients() {
        return ingredients;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }
}
