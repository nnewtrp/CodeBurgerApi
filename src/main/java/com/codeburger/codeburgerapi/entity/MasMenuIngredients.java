package com.codeburger.codeburgerapi.entity;

import jakarta.validation.constraints.NotNull;

public class MasMenuIngredients {
    @NotNull
    private String name;
    @NotNull
    private Integer amount;

    public MasMenuIngredients() {}

    public MasMenuIngredients(String name, Integer amount) {
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
