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
}
