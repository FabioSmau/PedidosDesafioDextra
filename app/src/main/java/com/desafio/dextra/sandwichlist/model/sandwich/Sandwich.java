package com.desafio.dextra.sandwichlist.model.sandwich;

import com.desafio.dextra.sandwichlist.model.ingredient.Ingredient;

import java.util.List;


public interface Sandwich {

    int getId();
    String getName();
    List<Ingredient> getIngredients();
    List<Integer> getIngredientsIdentifiers();
    String getImageUrl();
    void setIngredients(List<Ingredient> ingredients);
    double calculatePrice();

}
