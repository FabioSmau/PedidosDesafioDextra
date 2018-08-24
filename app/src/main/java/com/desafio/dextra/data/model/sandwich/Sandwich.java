package com.desafio.dextra.data.model.sandwich;

import com.desafio.dextra.data.model.ingredient.Ingredient;

import java.util.List;


public interface Sandwich {

    int getId();
    String getName();
    List<Ingredient> getIngredients();
    List<String> getIngredientsName();
    List<Integer> getIngredientsIdentifiers();
    String getImageUrl();
    void setIngredients(List<Ingredient> ingredients);
    String getPriceWithPromotionFormatted();
    double getTotalPriceWithPromotion();
    double getTotalPriceWithoutPromotion();

}
