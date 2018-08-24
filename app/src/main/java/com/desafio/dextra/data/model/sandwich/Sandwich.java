package com.desafio.dextra.data.model.sandwich;

import com.desafio.dextra.data.model.ingredient.Ingredient;

import java.util.List;


public interface Sandwich {

    int getId();
    String getName();
    List<Ingredient> getIngredients();
    List<String> getIngredientsName();
    void clearAllIngredients();
    String getImageUrl();
    void addIngredients(List<Ingredient> ingredients);
    void addIngredient(Ingredient ingredient);
    String getPriceWithPromotionFormatted();
    double getTotalPriceWithPromotion();
    double getTotalPriceWithoutPromotion();

}
