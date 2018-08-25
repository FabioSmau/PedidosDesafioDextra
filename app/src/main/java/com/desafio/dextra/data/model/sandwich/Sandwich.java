package com.desafio.dextra.data.model.sandwich;

import com.desafio.dextra.data.model.ingredient.Ingredient;
import com.desafio.dextra.data.model.promotions.strategy.DiscountStrategy;

import java.util.List;


public interface Sandwich  {

    String KEY_EXTRA = "SANDWICH_KEY_EXTRA";

    int getId();
    String getName();
    List<Ingredient> getIngredients();
    List<String> getIngredientsName();
    void clearAllIngredients();
    String getImageUrl();

    void addIngredients(List<Ingredient> ingredients);
    void addIngredient(Ingredient ingredient);


    String getPriceWithPromotionFormatted();
    double getTotalPriceWithPromotion(DiscountStrategy strategy);
    double getTotalPriceWithoutPromotion();
    boolean containsIngredient(int id);
    Ingredient getIngredient(int id);

}
