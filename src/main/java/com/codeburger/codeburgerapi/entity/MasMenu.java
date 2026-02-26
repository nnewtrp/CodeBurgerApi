package com.codeburger.codeburgerapi.entity;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "mas_menu")
public class MasMenu {
    @Id
    private String id;
    @NotNull
    private String name;
    @NotNull
    private String category;
    @NotNull
    private List<MasMenuIngredients> ingredients;

    public MasMenu() {}

    public MasMenu(String name, String category, List<MasMenuIngredients> ingredients) {
        this.name = name;
        this.category = category;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public List<MasMenuIngredients> getIngredients() {
        return ingredients;
    }
}