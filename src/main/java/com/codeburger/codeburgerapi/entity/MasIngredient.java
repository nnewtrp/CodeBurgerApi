package com.codeburger.codeburgerapi.entity;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mas_ingredient")
public class MasIngredient {
    @Id
    private String id;
    @NotNull
    private String name;
    @NotNull
    private String category;
    @NotNull
    private Double price;

    public MasIngredient() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
