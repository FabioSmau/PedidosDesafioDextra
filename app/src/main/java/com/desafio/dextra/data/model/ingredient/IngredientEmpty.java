package com.desafio.dextra.data.model.ingredient;

public class IngredientEmpty implements Ingredient {
    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getImageUrl() {
        return "";
    }
}
