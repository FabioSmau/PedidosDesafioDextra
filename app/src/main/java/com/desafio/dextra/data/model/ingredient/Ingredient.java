package com.desafio.dextra.data.model.ingredient;

public interface Ingredient {

    int getId();
    int getAmount();
    void addAmount();
    String getName();
    double getPrice();
    String getImageUrl();

}
