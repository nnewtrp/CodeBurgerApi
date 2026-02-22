package com.codeburger.codeburgerapi.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mas_ingredient")
public class MasIngredient {
    @Id
    private String id;
    private String name;
    private Double price;
    private String category;
}
